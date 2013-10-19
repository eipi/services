package name.eipi.services.appservice.rule;

import junit.framework.TestCase;
import name.eipi.services.specific.Fire;
import name.eipi.services.specific.Room;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.*;

/**
 * Created by dbdon_000
 * Date: 03/09/13
 */
public class SpecificTest extends TestCase {

  public static final String FILE_NAME = "specific";

  public void testEngine() throws Exception  {

    List<String> rooms = Arrays.asList(new String[]{"Hallway", "Kitchen", "Dining Room", "Living Room", "Bedroom", "Bathroom"});
    Iterator<String> roomIterator = rooms.iterator();

    StatefulKnowledgeSession session = new Engine().getKnowledgeSession(FILE_NAME);

    while (roomIterator.hasNext()) {
      session.insert(new Room(roomIterator.next()));
    }

    Fire fire =  new Fire();
    fire.setRoom(new Room(rooms.get(1)));
    session.insert(fire);

    session.fireAllRules();
    session.dispose();
  }

}
