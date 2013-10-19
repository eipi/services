package name.eipi.services.common;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 15/09/13
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesLoaderFactory {

    private static final String  PROPS_DIR = "resources/properties/";

    private static final String PROPS_FILE = "services.properties";

    public static PropertiesLoader getDefaultPropertiesLoader() {
        return new PropertiesLoader(PROPS_DIR  + PROPS_FILE);
    }

    public static PropertiesLoader getPropertiesLoader(final String propsFile) {
        return new PropertiesLoader(PROPS_DIR + propsFile);
    }

}
