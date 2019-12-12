package sessionCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet2")
public class sessionCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        String name = "";
        int quantity = 0;

        //get parameters from get request
        if (request.getParameter("name") != null){
            name = request.getParameter("name");
        } else {
            name = "Unknown";
        }
        if (request.getParameter("quantity") != null){
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } else {
            quantity = 0;
        }


        if (cart == null) {
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);

        }else {

        }

        session.setAttribute("cart", cart);

        getServletContext().getRequestDispatcher("/sessionCart.jsp").forward(request, response);
    }
}
