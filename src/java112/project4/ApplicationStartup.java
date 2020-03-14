package java112.project4;

import java.io.*;
import java.sql.*;
import java.util.*;

import java112.employee.*;
import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**<strong>This servlet will be initialization of Project 4</strong>
 * @author Andrew Diebold
 *
 */
 @WebServlet(
 name = "applicationStartup",
 urlPatterns = {"/project4-startup"},
 loadOnStartup = 1
 )

 public class ApplicationStartup extends HttpServlet {


    /**
     * The init method will load the properties file path into the
     * properties instance.
     *
     * @exception ServletException   If a servlet exception occurs.
     */

public void init() throws ServletException {

        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/project4.properties"));
            getServletContext().setAttribute("project4Properties", properties);

            EmployeeDirectory directory = new EmployeeDirectory(properties);
            getServletContext().setAttribute("project4Directory", directory);
        }
        catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }
}
