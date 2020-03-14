package java112.project3;

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
    name = "lab33Servlet",
    urlPatterns = { "/lab33Servlet"}
)

/**
 * This servlet outputs info to html
 */
public class Lab33Servlet extends HttpServlet {

    /**
     * Creates information generated in html
     * Handles HTTP GET requests.
     *
     * @param  request          the HttpServletRequest object
     * @param  response         the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data


        Map map = new HashMap();

        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This is an h2</h2>");
        map.put("aDate", new Date());

        request.setAttribute("myMap", map);

        String url = "/lab33.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }

}
