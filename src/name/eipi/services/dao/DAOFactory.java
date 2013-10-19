package name.eipi.services.dao;

import name.eipi.services.dao.api.IDynamicDAO;
import name.eipi.services.dao.api.ServicesDAO;
import name.eipi.services.to.SqlQuery;

import java.util.Map;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public class DAOFactory {

    public enum Mode {CONTAINER, STANDALONE}

    public static Mode MODE;

    static {
        MODE = Mode.CONTAINER;
    }

 public static ServicesDAO getServicesDAO() {
    return new ServicesDAOImpl();
  }

 public static IDynamicDAO getDynamicDAO(Map<String, SqlQuery> queries) {
     return new DynamicDAOImpl(queries);
 }

}
