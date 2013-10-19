package name.eipi.services.dao;

import name.eipi.services.dao.api.ServicesDAO;
import name.eipi.services.to.file.TextFile;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by dbdon_000
 * Date: 10/08/13
 */
public class ServicesDAOImpl implements ServicesDAO {

  /**
   * @return
   */
  public TextFile getTextFile(final String pathName) throws Exception{
    TextFile file = new TextFile(pathName);
    if (file.createNewFile()) {
      file.setNew(false);
    } else {
      file.setNew(true);
    }
    return file;
  }

}
