package name.eipi.services.to.object;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: dbdon_000
 * Date: 15/09/13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class Response {

    private Collection objs;

    public Response() {
        this.objs = new ArrayList();
    }

    public Collection getObjs() {
        return objs;
    }

    public void add(Object object) {
       objs.add(object);
    }

    public String toString() {
        return new Gson().toJson(this);
    }

}
