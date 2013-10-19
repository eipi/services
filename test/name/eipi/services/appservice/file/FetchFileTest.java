package name.eipi.services.appservice.file;

import junit.framework.TestCase;
import name.eipi.services.constants.DAOConstants;
import name.eipi.services.to.file.TextFile;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbdon_000
 * Date: 10/08/13
 */
public class FetchFileTest extends TestCase {

  private Map cache;

  protected final void setUp() {
    cache = new HashMap();
  }


  public final TextFile testFetchFile() throws Exception {
    if (cache.containsKey(DAOConstants.TEST_FILE)) {
      return (TextFile) cache.get(DAOConstants.TEST_FILE);
    } else {
      TextFile file = FetchFileCmd.fetchTextFile(DAOConstants.TEST_FILE);
      assertNotNull(file);
      cache.put(DAOConstants.TEST_FILE, file);
      return file;
    }

  }

  public final void testFileReadWrite() throws Exception {

    TextFile textFile =  testFetchFile();
    System.out.println("Reading from file:");
    System.out.println(textFile.read());
    System.out.println("Writing to file:");
    textFile.write(DAOConstants.TEST_MESSAGE +  new Date() + "\r\n");
    System.out.println("Reading from file:");
    System.out.println(textFile.read());
    System.out.println("Writing to file:");
    textFile.write(DAOConstants.TEST_MESSAGE +  new Date() + "\r\n");
    System.out.println("Reading from file:");
    System.out.println(textFile.read());
    System.out.println("Clearing file:");
    //textFile.clear();
    System.out.println("Reading from file:");
    System.out.println(textFile.read());
    System.out.println("Writing to file:");
    textFile.write(DAOConstants.TEST_MESSAGE +  new Date() + "\r\n");
    System.out.println("Reading from file:");
    System.out.println(textFile.read());

    textFile.deleteOnExit();
  }



}
