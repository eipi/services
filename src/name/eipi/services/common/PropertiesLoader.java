package name.eipi.services.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 15/09/13
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesLoader {

    private static String ENV;

    private static final String DELIM = ".";

    private final Properties properties;

    public Properties getProperties() {
        return this.properties;
    }

    protected PropertiesLoader(final String propertiesFileName) {
        properties = new Properties();
        InputStream in = null;
        try {
            in = ClassLoader.getSystemResourceAsStream(propertiesFileName);
            properties.load(in);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally  {
          if (null  != in) {
            try {
                in.close();

            } catch (Throwable  t) {
                in = null;
            }
          }
        }
        ENV = getEnv();
    }

    private String getEnv() {
        if (ENV == null) {
            ENV = properties.getProperty("env");
        }
        return ENV;
    }

    public String getProperty(final String propertyName) {
        if (ENV != null) {
            return properties.getProperty(ENV + DELIM + propertyName);
        }
        else return properties.getProperty(propertyName);

    }
}
