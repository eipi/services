package name.eipi.services.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * Created by dbdon_000
 * Date: 21/08/13
 */
public class ToStringBuilder {

  public static String toString(final Object o) {
    if  (o == null){
      return null;
    }
    StringBuilder builder = new StringBuilder();
    builder.append(o.getClass());
    builder.append("\n");
    if (o  instanceof Iterable) {
      Iterator it = ((Iterable) o).iterator();
      while (it.hasNext()) {
        builder.append(toString(it.next()));
      }
    }

    try {
      Class c =  Class.forName(o.getClass().getName());
      Field[] fields =  c.getDeclaredFields();
      Method[]  methods = c.getDeclaredMethods();
      builder.append(fields).append(methods);
    } catch (ClassNotFoundException ex) {
      builder.append(o.toString());
    }
    return builder.toString();
  }

}
