package name.eipi.services.dao.api;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 13/09/13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public interface IDynamicDAO {



    Collection<Map>  execute(String query, Map<Integer, String>  params) throws Exception;

    Collection<Map>  execute(String query, Object... params) throws Exception;

    Collection<Collection<Map>> get(String query, Object... params) throws Exception;

    Collection<Collection<Map>> get(String query, Map<Integer, String> params) throws Exception;


}
