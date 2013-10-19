package name.eipi.services.dao;

import name.eipi.services.constants.ApplicationConstants;
import name.eipi.services.constants.DAOConstants;
import name.eipi.services.logger.Logger;
import name.eipi.services.logger.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public class ConnectionFactory {

  private final static String CONNECTION_STRING;

  static {
    try {
      Class.forName(ApplicationConstants.MSSQLSERVER_DRIVER);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    CONNECTION_STRING = buildConnectionString(DAOConstants.Services);

  }

  private static String buildConnectionString(final String datasource) {
    StringBuilder sb = new StringBuilder();
    sb.append(DAOConstants.JDBC_PREFIX).append(DAOConstants.DB_SERVER);
    sb.append(";databaseName=").append(datasource);
    sb.append(";username=").append("sa");
    sb.append(";password=").append("uop7nnobv1");
    sb.append(";");
    return sb.toString();
  }

  public static Connection getConnection(final String datasource) throws Exception {
    return DriverManager.getConnection(buildConnectionString(datasource));
  }

}
