package name.eipi.services.dao;

import name.eipi.services.dao.api.IDynamicDAO;
import name.eipi.services.logger.Logger;
import name.eipi.services.logger.LoggerFactory;
import name.eipi.services.to.SqlQuery;
import name.eipi.services.dao.DAOFactory.Mode;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 13/09/13
 * Time: 18:59
 * To change this template use File | Settings | File Templates.
 */
public class DynamicDAOImpl implements IDynamicDAO {

    private static  final Logger LOGGER = LoggerFactory.getInstance(DynamicDAOImpl.class);

    private Map<String, DataSource> cache = new HashMap<>();

    private final Map<String, SqlQuery> queries;


    public DynamicDAOImpl(final Map<String, SqlQuery> queries) {
        this.queries = queries;
    }

    @Override
    public Collection<Collection<Map>> get(String query, Object... params) throws Exception {
        Collection<Collection<Map>> mapCollection = new ArrayList<>();
        mapCollection.add(this.execute(query,  params));
        return mapCollection;
    }

    @Override
    public Collection<Collection<Map>> get(String query, Map<Integer, String> params) throws Exception {
        Collection<Collection<Map>> mapCollection = new ArrayList<>();
        mapCollection.add(this.execute(query,  params));
        return mapCollection;
    }

    @Override
    public Collection<Map> execute(String query, Map<Integer, String> params) throws Exception {
        if  (!queries.containsKey(query)) {
            throw new Exception("Query " + query +  " not found.");
        }
        SqlQuery sqlQuery = queries.get(query);

        Connection connection = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;

        try {
            connection = getConnection(sqlQuery.getDatasource());
            ps = connection.prepareStatement(sqlQuery.getQuery());

            Iterator<Integer> iterator = params.keySet().iterator();
            while (iterator.hasNext()) {
                Integer i =  iterator.next();
                ps.setString(i, params.get(i));
            }

            LOGGER.debug("Executing query " + sqlQuery.getQuery() + " [" +  params + "]");
            rs = ps.executeQuery();

            Collection<Map> results = convertResultSetToMapCollection(rs);
            return results;
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }
    }


    @Override
    public Collection<Map> execute(String query, Object... params) throws Exception {
        Map<Integer, String> paramters = new HashMap<>();
        if  (params != null && params.length > 0) {
            for  (int i = 0; i  <params.length; i++) {
                paramters.put(i+1, (params[i] != null) ? params[i].toString() : null);
            }
        }
        return this.execute(query, paramters);
    }

    private static Collection<Map> convertResultSetToMapCollection(final ResultSet rs) throws SQLException {

        Collection<Map> results = new ArrayList<Map>();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Collection<String> columns = new ArrayList<String>();
        for (int i = 0; i < columnCount; i++) {
            columns.add(rsmd.getColumnLabel(i + 1));
        }

        while (rs.next()) {
            Map  row = new HashMap();
            Iterator<String> it  = columns.iterator();
            while (it.hasNext()) {
                String columnName = it.next();
                String value = rs.getString(columnName);
                if (value != null) {
                    row.put(columnName, rs.getString(columnName));
                }
            }
            results.add(row);
        }
        return results;

    }

    private Connection getConnection(String name) throws Exception{
        if (DAOFactory.MODE ==  Mode.CONTAINER) {
            if (cache.containsKey(name)) {
                return cache.get(name).getConnection();
            }
            InitialContext context  = new InitialContext();
            DataSource ds = (DataSource) context.lookup(name);
            cache.put(name, ds);
            return ds.getConnection();
        } else {
            return ConnectionFactory.getConnection(name);
        }
    }

}
