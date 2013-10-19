package name.eipi.services.logger;

import name.eipi.services.appservice.file.FetchFileCmd;
import name.eipi.services.constants.ApplicationConstants;
import name.eipi.services.constants.LoggerConstants;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by dbdon_000
 * Date: 10/08/13
 */
public class LoggerImpl implements Logger {

  private static final Calendar CALENDAR = Calendar.getInstance();

  private final String className;

  @Override
  public void debug(String message) {

    String destination = ApplicationConstants.APP_NAME + LoggerConstants.DEBUG
            + CALENDAR.get(Calendar.YEAR) + CALENDAR.get(Calendar.MONTH) + CALENDAR.get(Calendar.DATE);
    try {
      FetchFileCmd.fetchTextFile(destination).write("[" + className + "] "+ new Date() + " [" + message + "]\r\n");
    }catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  @Override
  public void debug(String message, Object object) {
    String destination = ApplicationConstants.APP_NAME + LoggerConstants.DEBUG
            + CALENDAR.get(Calendar.YEAR) + CALENDAR.get(Calendar.MONTH) + CALENDAR.get(Calendar.DATE);
    try {
      FetchFileCmd.fetchTextFile(destination).write("[" + className + "] "+ new Date() + " [" + message + "\r\n"
              + ((object == null) ? object :  object.toString()) +  "]\r\n");
    }catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void error(String message) {
    String destination = ApplicationConstants.APP_NAME + LoggerConstants.ERROR
            + CALENDAR.get(Calendar.YEAR) + CALENDAR.get(Calendar.MONTH) + CALENDAR.get(Calendar.DATE);
    try {
      FetchFileCmd.fetchTextFile(destination).write("[" + className + "] "+ new Date() + " [" + message + "]\r\n");
    }catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void error(String message, Object object) {
    String destination = ApplicationConstants.APP_NAME + LoggerConstants.ERROR
            + CALENDAR.get(Calendar.YEAR) + CALENDAR.get(Calendar.MONTH) + CALENDAR.get(Calendar.DATE);
    try {
      FetchFileCmd.fetchTextFile(destination).write("[" + className + "] "+ new Date() + " [" + message + "\r\n"
              + ((object == null) ? object
              : (object instanceof Throwable) ? ExceptionUtils.getStackTrace((Throwable) object) : object.toString())
              +  "]\r\n");
    }catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  LoggerImpl(final Class clazz){
    className = clazz.getName();
  }

}
