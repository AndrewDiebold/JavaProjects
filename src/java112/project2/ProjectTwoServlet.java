/*
 *  Class: ProjectTwoServlet
 *  Author: Andrew Diebold
 *  Create date: 10/22/2019
 *  Modification date: 10/22/2019
 *  Description: This class is the Servlet for Project 2 properties
 */

package java112.project2;

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
    name = "projectTwoServlet",
    urlPatterns = { "/projectTwoServlet"}
)

/**
 * This servlet loads the properties object and outputs to html
 */
public class ProjectTwoServlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;

    /**
     * loads properties file into a properties object
     * @param  config           ServletConfig
     * @throws ServletException if there is a Servlet failure
     */
    public void init(ServletConfig config) throws ServletException {
        try {
            properties = loadProperties("/project2.properties");
        } catch (Exception exception) {
            log("Error in PropertiesReader init" + exception);
        }
    }

    /**
     * Provides all the information for the user
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
        out.print("<HEAD><TITLE>Project 2 Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Advanced Java 112</h1>");
        out.print("<h3>Andrew Diebold</h3>");
        out.print("<a href='/java112'>Home</a><br /><br />");
        out.print("<table style='width: 50%;'>");

        out.print("<tr style='background-color:#e1e1e1;'>");
        out.print("<td style='border: 1px solid black;'><strong>Project Author</strong></td>");
        out.print("<td>" + properties.getProperty("author") + "</td>");
        out.print("</tr>");

        out.print("<tr style='background-color:#e1e1e1;'>");
        out.print("<td  style='border: 1px solid black;'><strong>Email</strong></td>");
        out.print("<td>" + properties.getProperty("author.email.address") + "</td>");
        out.print("</tr>");

        out.print("<tr style='background-color:#e1e1e1;'>");
        out.print("<td style='border: 1px solid black;'><strong>Course</strong></td>");
        out.print("<td>" + properties.getProperty("course.title") + "</td>");
        out.print("</tr>");

        out.print("<tr style='background-color:#e1e1e1;'>");
        out.print("<td style='border: 1px solid black;'><strong>Course Meeting Times</strong></td>");
        out.print("<td>" + properties.getProperty("course.meeting.times") + "</td>");
        out.print("</tr>");

        out.print("<tr style='background-color:#e1e1e1;'>");
        out.print("<td style='border: 1px solid black;'><strong>Course Instructor</strong></td>");
        out.print("<td>" + properties.getProperty("course.instructor") + "</td>");
        out.print("</tr>");

        out.print("<tr style='background-color:#e1e1e1;'>");
        out.print("<td style='border: 1px solid black;'><strong>Project Description</strong></td>");
        out.print("<td>" + properties.getProperty("project.description") + "</td>");
        out.print("</tr>");



        out.print("</table>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
