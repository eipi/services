package name.eipi.services.web;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */

import com.google.gson.Gson;
import name.eipi.services.appservice.web.WebDataLoader;
import name.eipi.services.dao.DAOFactory;
import name.eipi.services.to.entity.Entry;
import name.eipi.services.to.file.TextFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class ServicesHomePage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {

            // Get some data
            String msg = new Gson().toJson(WebDataLoader.getTestData());
            writer.write(msg);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
