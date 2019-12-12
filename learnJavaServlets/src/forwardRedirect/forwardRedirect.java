package forwardRedirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "forward")
public class forwardRedirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // USING REDIRECT
            //response.sendRedirect("https://www.google.com");
            //response.sendRedirect("/testingForward.jsp");

        // USING FORWARD
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testingForward.jsp");
        dispatcher.forward(request, response);

    }
}
