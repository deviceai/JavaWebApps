import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class dbview extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
                            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
                        throws javax.servlet.ServletException, IOException {

        final String URL = "jdbc:mysql://localhost:3306/esptest";
        final String USER = "root";
        final String PASS = "power7805";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Results:";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body><h2>" + title + "</h2>\n");

        //Connect to database
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");  //Register DB driver
            connection = DriverManager.getConnection(URL,USER,PASS);
            //System.out.println(!connection.isClosed() ? "Connected!" : "Not connected!" );  //For debug

            Statement stmt = connection.createStatement();
            String sql = "SELECT id, temp, humidity, esp_status FROM esp8266";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int temp = rs.getInt("temp");
                int humidity = rs.getInt("humidity");
                String esp_status = rs.getString("esp_status");

                //Display values
                out.println("ID: " + id);
                out.println(", Temp: " + temp);
                out.println(", Humidity: " + humidity);
                out.println(", Status: " + esp_status + "<br>");
            }

            out.println("<p></p>");
            out.println("<a href=\"/esp/\">back to main page</a>");
            out.println("</body></html>");
            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }


    }
}
