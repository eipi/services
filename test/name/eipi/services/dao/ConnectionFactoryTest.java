package name.eipi.services.dao;

import junit.framework.TestCase;
import name.eipi.services.constants.DAOConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public class ConnectionFactoryTest extends TestCase {

  private static final String CONNECTION_TEST_QUERY = "SELECT a.v FROM app_t a WITH(NOLOCK) WHERE a.k = ?";

  public void testConnectionFactory() throws Exception {
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String response = null;

    try {
      c = ConnectionFactory.getConnection(DAOConstants.Services);
      ps = c.prepareCall(CONNECTION_TEST_QUERY);
      ps.setString(1, DAOConstants.MARCO);
      rs = ps.executeQuery();
      while (rs.next()) {
        response = rs.getString(1);
        break;
      }
    } finally {
      if (rs != null) {
        rs.close();
      }
      if (ps != null) {
        ps.close();
      }
      if (c != null) {
        c.close();
      }
    }
    assertTrue(DAOConstants.POLO.equals(response));
  }


}
