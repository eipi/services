package name.eipi.services.logger;

/**
 * Created by dbdon_000
 * Date: 10/08/13
 */
public class LoggerFactory {

  public static Logger getInstance(final Class clazz) {
    return new LoggerImpl(clazz);
  }

}
