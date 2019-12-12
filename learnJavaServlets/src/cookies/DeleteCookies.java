package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCookies")
public class DeleteCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookie = new Cookie("some_id", "");
        cookie.setMaxAge(0); //rewrite cookie, send new cookie with come id and with age = 0, browser will delite this cookie

        // cookie.setMaxAge(-1); //will delete cookie when client close browser

        response.addCookie(cookie);
    }
}
