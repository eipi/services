package name.eipi.services.to;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 13/09/13
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
public class SqlQuery {

    public SqlQuery(String query, String datasource) {
        this.query = query;
        this.datasource = datasource;
    }

    private String query;

    private String datasource;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }
}
