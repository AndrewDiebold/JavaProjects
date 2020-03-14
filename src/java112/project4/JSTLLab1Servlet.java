package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  JSTL Lab 1 Servlet
 *
 *@author    Andrew Diebold
 */
@WebServlet(
        name = "jstlServlet",
        urlPatterns = { "/jstlServlet" }
)
public class JSTLLab1Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        List<String> packersPlayers = new ArrayList<String>();
        packersPlayers.add("Aaron Rodgers");
        packersPlayers.add("Brett Farve");
        packersPlayers.add("Bart Starr");
        request.setAttribute("packersQBs", packersPlayers);
        String url = "/jstl-lab2.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
