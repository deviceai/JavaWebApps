import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dbadmin")
public class dbadmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Admin Panel";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body><h2>" + title + "</h2>\n" +
                "<p><b>Add new record to database:</b></p>\n" +
                "<form action = \"dbadd\" method = \"GET\">\n" +
                "    ID: <input type = \"text\" name = \"id\">\n" +
                "    <br />\n" +
                "    Temerature: <input type = \"text\" name = \"temp\">\n" +
                "    <br />\n" +
                "    Humidity: <input type = \"text\" name = \"humidity\">\n" +
                "    <br />\n" +
                "    ESP Status: <input type = \"text\" name = \"esp_status\" />\n" +
                "    <input type = \"submit\" value = \"Submit\" />\n" +
                "</form>" +
                "<p></p>" +
                "<a href=\"/esp/\">back to main page</a>" +
                "</body></html>");

    }
}
