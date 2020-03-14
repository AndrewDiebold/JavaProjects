package java112.project2;

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
    name = "first112Servlet",
    urlPatterns = { "/first112Servlet"}
)

/**
 * This servlet outputs info to html
 */
public class First112Servlet extends HttpServlet {

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
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First Java112 Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Advanced Java 112</h1>");
        out.print("<h3>Andrew Diebold</h3>");
        out.print("<a href='/java112'>Home</a><br /><br />");
        out.print("<img src='/java112/images/java.jpg'>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
