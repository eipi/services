package name.eipi.services.eao;

import name.eipi.services.eao.api.ServicesEAO;
import name.eipi.services.logger.Logger;
import name.eipi.services.logger.LoggerFactory;
import name.eipi.services.to.entity.EntityTO;
import name.eipi.services.to.entity.EntityTOKey;
import name.eipi.services.to.entity.Entry;
import name.eipi.services.to.entity.Type;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
class ServicesEAOImpl implements ServicesEAO {

  private static final Logger LOGGER = LoggerFactory.getInstance(ServicesEAOImpl.class);

  private final EntityManager entityManager;

  ServicesEAOImpl(final EntityManager entityManagerIn) {
    entityManager = entityManagerIn;
  }


  @Override
  public void create(EntityTO entity) throws Exception {
    // begin transaction
    entityManager.getTransaction().begin();
    try {
      if (!entityManager.contains(entity)) {
        // persist object - add to entity manager
        entityManager.persist(entity);
        // flush em - save to DB
        entityManager.flush();
        // commit transaction
        entityManager.getTransaction().commit();
      }
    } catch (Exception ex) {
      LOGGER.error(ex.getMessage(), ex);
      entityManager.getTransaction().rollback();
      throw ex;
    }
  }

  @Override
  public<T extends EntityTO> T read(final Class<T> clazz, EntityTOKey entityKey) {
    return entityManager.find(clazz, entityKey, LockModeType.NONE);
  }

  @Override
  public void update(EntityTO entity) throws Exception {
    // begin transaction
    entityManager.getTransaction().begin();
    try {
        // persist object - add to entity manager
        entityManager.persist(entity);
        // flush em - save to DB
        entityManager.flush();
        // commit transaction
        entityManager.getTransaction().commit();
    } catch (Exception ex) {
      LOGGER.error(ex.getMessage(), ex);
      entityManager.getTransaction().rollback();
      throw  ex;
    }
  }

  public void delete(EntityTO entity) {
    // begin transaction
    entityManager.getTransaction().begin();
    try {
      entityManager.remove(entity);
        // commit transaction
        entityManager.getTransaction().commit();
    } catch (Exception ex) {
      LOGGER.error(ex.getMessage(), ex);
      entityManager.getTransaction().rollback();
    }
  }

    public <T extends EntityTO> Collection<T> readAll(Class<T> clazz) {
        EntityManager em = EAOFactory.getEntityManager();
        try {
            if (Entry.class.equals(clazz)) {
                Query query = em.createQuery("SELECT e FROM Entry e");
                return (Collection<T>) query.getResultList();
            } else if (Type.class.equals(clazz)) {
                Query query = em.createQuery("SELECT t FROM Type t");
                return (Collection<T>) query.getResultList();
            }
        } finally {
            em.close();
        }
        return null;
    }

  public void finalize() {
    entityManager.close();
  }

}

