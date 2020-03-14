package java112.project3;

import java112.utilities.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    AndrewDibold
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = { "/project3-properties"}
)

/**
 * This servlet assigns the data to output on jsp page
 */
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;


    /**
     * The init method loads the properties file path into the properties instance.
     *
     * @exception ServletException   If a servlet exception occurs.
     */
    public void init() throws ServletException {
        try {
            properties = loadProperties("/project3.properties");
        } catch (Exception exception) {
            log("Error in PropertiesReader init" + exception);
        }
    }




    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        request.setAttribute("project3Properties", properties);

        String url = "/project3Properties.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
