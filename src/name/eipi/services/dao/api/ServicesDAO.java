package name.eipi.services.dao.api;


import name.eipi.services.to.file.TextFile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public interface ServicesDAO {

  public TextFile getTextFile(final String pathName)  throws Exception;

}
