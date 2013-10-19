package name.eipi.services.appservice.file;

import junit.framework.TestCase;

/**
 * Created by dbdon_000
 * Date: 21/08/13
 */
public class ScannerTest extends TestCase {

  public void testScanner()  throws Exception {
    Scanner scanner = new Scanner();
    scanner.executeFullScan();
  }


}
