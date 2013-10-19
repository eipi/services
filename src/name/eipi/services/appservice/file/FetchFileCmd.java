package name.eipi.services.appservice.file;

import name.eipi.services.dao.DAOFactory;
import name.eipi.services.to.file.TextFile;

/**
 * Created by dbdon_000
 * Date: 10/08/13
 */
public class FetchFileCmd {
  public static TextFile fetchTextFile(final String pathName) throws Exception {
     return DAOFactory.getServicesDAO().getTextFile(pathName);
  }
}
