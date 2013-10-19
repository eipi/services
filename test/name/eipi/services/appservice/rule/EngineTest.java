package name.eipi.services.appservice.rule;

import junit.framework.TestCase;
import name.eipi.services.common.PropertiesLoader;
import name.eipi.services.common.PropertiesLoaderFactory;
import name.eipi.services.dao.DAOFactory;
import name.eipi.services.dao.api.IDynamicDAO;
import name.eipi.services.to.SqlQuery;
import name.eipi.services.to.object.Response;
import org.drools.event.rule.AgendaEventListener;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

import java.util.*;

/**
 * Created by dbdon_000
 * Date: 16/08/13
 */
public class EngineTest extends TestCase {

  public static final String FILE_NAME = "engine";

    static {
        DAOFactory.MODE = DAOFactory.Mode.STANDALONE;
    }

  public void testEngine() throws Exception  {

    StatefulKnowledgeSession session = new Engine().getKnowledgeSession(FILE_NAME);
    AgendaEventListener listener = new Listener();
    session.addEventListener(listener);

      PropertiesLoader props  = PropertiesLoaderFactory.getPropertiesLoader("queries.properties");

      Set<String> keys =  props.getProperties().stringPropertyNames();

      Map<String, SqlQuery> args =  new HashMap<>();

      for (Iterator<String> it = keys.iterator(); it.hasNext(); ) {
          String ds = "";
          String queryName = it.next();

          SqlQuery query =  new SqlQuery(props.getProperty(queryName), ds);
          args.put(queryName, query);

      }
      IDynamicDAO dao = DAOFactory.getDynamicDAO(args);

    session.setGlobal("dao", dao);
      Response response  = new Response();
    session.setGlobal("response", response);
    session.fireAllRules();
    ObjectFilter filter = new MatchFilter();
    Collection<FactHandle> factHandles =  session.getFactHandles(filter);
    Iterator<FactHandle> factHandleIterator = factHandles.iterator();
    while (factHandleIterator.hasNext()) {
      System.out.println("Found " + (session.getObject(factHandleIterator.next())));
    }
    System.out.println("Response : " + response);
    session.dispose();
  }

}
