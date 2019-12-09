import java.io.IOException;
import java.io.PrintWriter;

public class ServletESP extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter pw =  response.getWriter();

        pw.println("<html><body>");
        pw.println("ESP servlet");
        pw.println("</body></html>");
    }
}
