package name.eipi.services.appservice.rule;

import junit.framework.TestCase;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 11/09/13
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
public class MonitorTest extends TestCase {

    private final static String FILE_NAME = "monitor";

    private final static int NUM = 1;

    public void testMonitor() throws Exception {

        StatefulKnowledgeSession session = new Engine().getKnowledgeSession(FILE_NAME, NUM);
        session.fireAllRules();
        session.dispose();


    }


}
