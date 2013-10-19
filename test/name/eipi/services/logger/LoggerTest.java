package name.eipi.services.logger;

import junit.framework.TestCase;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public class LoggerTest extends TestCase {

  Logger LOGGER = LoggerFactory.getInstance(LoggerTest.class);

  public void testLogger() throws Exception {
    LOGGER.debug("Writing a debug message.");
    try {
      throwArithmeticException();
    } catch (Exception ex) {
      LOGGER.error("Throwing an exception.", ex);
    }

  }

  private static Object throwArithmeticException() {
    int one = 1;
    int zero =  0;
    int infinity = one / zero;
    return infinity;
  }

}
