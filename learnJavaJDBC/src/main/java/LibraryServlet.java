import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LibraryServlet")
    public class LibraryServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            PrintWriter pw = response.getWriter();
            pw.println("<html><body>");

            try {  Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) { e.printStackTrace();  }

            try { Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/java_ee_db", "java", "java");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select title from books");

                while(rs.next()){
                    pw.println("<p>" + rs.getString("title") + "</br></p>");
                }

                stmt.close();
            } catch (SQLException e) { e.printStackTrace(); }




        }
    }

