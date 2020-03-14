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
    name = "LabFive",
    urlPatterns = { "/LabFive"}
)
public class LabFive extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
        log("init");
    }




    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            Date date = new Date();
            HttpSession session = request.getSession(true);
            Date createTime = new Date(session.getCreationTime());

            response.setContentType("text/html");

             hitCount++;
             PrintWriter out = response.getWriter();

             out.println("<html><body>" +
                "<table><tr><th style=padding:10px;>Hit Count</th>" +
                "<th style=padding:10px;>Date Accessed for First Time</th>" +
                "<th style=padding:10px;>Current Time</th></tr>" +
                "<tr><td style=padding:10px;>" + hitCount + "</td>" +
                "<td style=padding:10px;>" + createTime +
                "</td><td style=padding:10px;>" + date.toString() +
                "</td></tr>" +
                "</table></body></html>"
              );
              log("doGet");

    }



}
