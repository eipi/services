package name.eipi.services.appservice.rule;

import junit.framework.TestCase;
import org.drools.KnowledgeBase;
import org.drools.common.DroolsObjectInputStream;
import org.drools.common.DroolsObjectOutputStream;
import org.drools.runtime.StatefulKnowledgeSession;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 08/10/13
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public class SerializationTest extends TestCase {

    public void testSerialization() throws Exception {
        File file =  new File("drools-serialization-test");
        KnowledgeBase  knowledgeBase = new Engine().getKnowledgeBase("engine", 0);
        OutputStream outputStream = new FileOutputStream(file);
        DroolsObjectOutputStream objectOutputStream = new DroolsObjectOutputStream(outputStream);
        objectOutputStream.writeObject(knowledgeBase);
        objectOutputStream.close();
        outputStream.close();
    }

    public void testDeserialization() throws Exception {
        File file =  new File("drools-serialization-test");
        InputStream inputStream = new FileInputStream(file);
        DroolsObjectInputStream objectInputStream = new DroolsObjectInputStream(inputStream);
        KnowledgeBase knowledgeBase = (KnowledgeBase) objectInputStream.readObject();
        StatefulKnowledgeSession kSession = knowledgeBase.newStatefulKnowledgeSession();
        kSession.fireAllRules();
        objectInputStream.close();
        inputStream.close();

    }

}
