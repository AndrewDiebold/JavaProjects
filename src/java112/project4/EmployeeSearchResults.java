package java112.project4;

import java.io.*;
import java.sql.*;
import java.util.*;

import java112.employee.*;
import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**<strong>This Servlet will perform searches for employees.</strong>
 * @author Andrew Diebold
 *
 */
@WebServlet(
name = "searchResults",
urlPatterns = {"/searchResults"}
) public class EmployeeSearchResults extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param        request             the HttpRequest
     *@param        response            the HttpResponse
     *@exception    ServletException    if there is a general servlet exception
     *@exception    IOException         if there is a general I/O exception
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        HttpSession session = request.getSession();

        EmployeeDirectory directory = (EmployeeDirectory)context.getAttribute("project4Directory");

        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        if (searchTerm == null || searchTerm.equals("")) {

            String searchResultsMessage = "Please type a term to search";
            session.setAttribute("searchMessage", searchResultsMessage);

        } else {

            Search search = directory.searchEmployeeDatabase(searchTerm, searchType);
            session.setAttribute("searchResult", search);

        }

        String url = "/employeeSearchResults.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
