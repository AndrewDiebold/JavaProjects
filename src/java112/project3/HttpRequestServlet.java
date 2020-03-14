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
    name = "request-servlet",
    urlPatterns = { "/request-servlet"}
)

/**
 * This servlet assigns the data to output on jsp page
 */
 public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData requestData = new HttpRequestData();

        requestData.setRemoteComputer(request.getRemoteHost());
        requestData.setRemoteComputerAddress(request.getRemoteAddr());
        requestData.setHttpMethod(request.getMethod());
        requestData.setRequestUri(request.getRequestURI());
        requestData.setRequestUrl(request.getRequestURL());
        requestData.setProtocalRequest(request.getProtocol());
        requestData.setServerName(request.getServerName());
        requestData.setServerPortNumber(request.getServerPort());
        requestData.setCurrentServerLocale(request.getLocale());
        requestData.setQuery(request.getQueryString());
        requestData.setQueryParameter(request.getParameter("queryParameter"));
        requestData.setUserAgent(request.getHeader("User-Agent"));

        request.setAttribute("project3Bean", requestData);

        String url = "/project3DataRequest.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
