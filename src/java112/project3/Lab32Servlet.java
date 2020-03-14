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
    name = "lab32Servlet",
    urlPatterns = { "/lab32Servlet"}
)

/**
 * This servlet outputs info to html
 */
public class Lab32Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>Lab 3-2 Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Lab 3-2 Servlet</h1>");
        out.print("<ul>");
        out.print("<li>Current Locale: " + request.getLocale() + "</li>");

        out.print("<li>Context Path: " + request.getContextPath() + "</li>");

        out.print("<li>Local Name of Server: " + request.getServerName() + "</li>");

        out.print("<li>Scheme used: " + request.getScheme() + "</li>");
        out.print("</ul>");
        out.print("<a href='/java112'>Home</a><br /><br />");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
