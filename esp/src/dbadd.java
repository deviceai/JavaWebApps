import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "dbadd")
public class dbadd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final String URL = "jdbc:mysql://localhost:3306/esptest";
        final String USER = "root";
        final String PASS = "password";

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        String title = "Adding data to database";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        int id = Integer.parseInt(request.getParameter("id"));
        int temp = Integer.parseInt(request.getParameter("temp"));
        int humidity = Integer.parseInt(request.getParameter("humidity"));
        String esp_status = request.getParameter("esp_status");


        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<p>Adding data to database...</p>"
        );

        // browser example http://localhost:8080/esp/dbadd?id=2&temp=25&humidity=50&esp_status=OK


        //connect to database
        Connection conn = null;
        // Register JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            //Assume a valid connection object conn
            conn = DriverManager.getConnection(URL,USER,PASS);
            //System.out.println(!conn.isClosed() ? "Connected!" : "Not connected!" );
            out.println(!conn.isClosed() ? "<p>Connected to database!</br></p>" : "<p>Unable connect to database!</br></p>");

            //new variant
            String query = "INSERT INTO  esp8266 (id, temp, humidity, esp_status)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, id);
            preparedStmt.setInt (2, temp);
            preparedStmt.setInt   (3, humidity);
            preparedStmt.setString(4, esp_status);

            preparedStmt.execute();
            out.println("<p>Added to database!</br></p>");
            conn.close();

        }catch(SQLException se){
            try { conn.rollback(); } catch (SQLException e) { e.printStackTrace(); }
        }

        out.println("<p></p>");
        out.println("<a href=\"/esp/\">back to main page</a>");
        out.println("</body></html>");

    }
}
