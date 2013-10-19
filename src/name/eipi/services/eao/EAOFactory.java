package name.eipi.services.eao;

import name.eipi.services.constants.ApplicationConstants;
import name.eipi.services.eao.api.ServicesEAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public class EAOFactory {

  private static EntityManagerFactory entityManagerFactory;

  static {
    try {
      Class.forName(ApplicationConstants.MSSQLSERVER_DRIVER);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    entityManagerFactory = Persistence.createEntityManagerFactory("Services1", System.getProperties());
  }

  public static ServicesEAO getEAO() {
    return new ServicesEAOImpl(entityManagerFactory.createEntityManager());
  }

  public static EntityManager getEntityManager()  {
      return entityManagerFactory.createEntityManager();
  }

  public void finalize() {
    entityManagerFactory.close();
  }

}
