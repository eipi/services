package name.eipi.services.eao.api;

import name.eipi.services.to.entity.EntityTO;
import name.eipi.services.to.entity.EntityTOKey;

import java.util.Collection;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public interface ServicesEAO {

  public void create(final EntityTO entity) throws Exception;

  public<T extends EntityTO> T read(final Class<T> clazz, EntityTOKey entityTOKey);

  public void update(EntityTO entity) throws Exception;

  public void  delete(EntityTO entityKey);

  public <T extends EntityTO> Collection<T> readAll(Class<T> clazz);

}
