import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ServletDBadd")
public class ServletDBadd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String URL = "jdbc:mysql://localhost:3306/esptest";
        final String USER = "root";
        final String PASS = "power7805";

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        String title = "Using GET Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String firstname = request.getParameter("first_name");
        String lastname = request.getParameter("last_name");




        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>ID</b>: "
                + request.getParameter("id") + "\n" +
                "  <li><b>Age</b>: "
                + request.getParameter("age") + "\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body>" +
                "</html>"
        );

        // browser http://localhost:8080/add?id=2&age=25&first_name=AA&last_name=BB



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
            System.out.println(!conn.isClosed() ? "Connected!" : "Not connected!" );

            //new variant
            String query = "INSERT INTO  Employees (id, age, first, last)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, id);
            preparedStmt.setInt (2, age);
            preparedStmt.setString   (3, firstname);
            preparedStmt.setString(4, lastname);

            preparedStmt.execute();
            conn.close();

        }catch(SQLException se){
            try { conn.rollback(); } catch (SQLException e) { e.printStackTrace(); }
        }




    }

}
