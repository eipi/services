package name.eipi.services.dao;


import com.google.gson.Gson;
import junit.framework.TestCase;
import name.eipi.services.dao.api.IDynamicDAO;
import name.eipi.services.to.SqlQuery;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 13/09/13
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */
public class DynamicDAOTest extends TestCase {

    private static final String SQL = "SELECT * FROM user_t;";

    private static final String DATASOURCE = "";

    static {
        DAOFactory.MODE =  DAOFactory.Mode.STANDALONE;
    }

    public void testDynamicDAO() throws Exception {

        Map<String, SqlQuery> queries = new HashMap<>();
        queries.put("SQL", new SqlQuery(SQL, DATASOURCE));

        IDynamicDAO dao  = DAOFactory.getDynamicDAO(queries);
        Collection c = dao.execute("SQL");
        System.out.println(new Gson().toJson(c));

    }



}
