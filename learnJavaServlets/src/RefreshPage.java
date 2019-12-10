import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RefreshPage extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        response.setIntHeader("Refresh", 5);
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        String pageTitle = "Auto refresh header settings";

        writer.println("<html><body>");
        writer.println("<h2>" + pageTitle + "</h2>");

        java.util.Date Date = new Date();

        writer.println("<p>" + Date + "</p>");
        writer.println("</body></html>");
    }
}
