package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet")
public class userSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession usersession = request.getSession();
        Integer count = (Integer) usersession.getAttribute("count");
        if (count == null) {
            usersession.setAttribute("count", 1);
            count = 1;
        } else {
            usersession.setAttribute("count", count+1); }

        PrintWriter writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<p> Visiting count: " + count + " </p>");
        writer.println("</body></html>");

    }
}
