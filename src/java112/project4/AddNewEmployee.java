package java112.project4;

import java.io.*;
import java.sql.*;
import java.util.*;

import java112.employee.*;
import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**<strong>This servlet will forward to the add employee JSP</strong>
 * @author Andrew Diebold
 *
 */
@WebServlet(
name = "addNewEmployee",
urlPatterns = {"/addNewEmployee"}
) public class AddNewEmployee extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String url = "/addEmployee.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
