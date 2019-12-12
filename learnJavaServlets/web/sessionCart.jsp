

<%--
  Created by IntelliJ IDEA.
  User: aleksandralba
  Date: 12/12/2019
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
    <%@ page import="sessionCart.Cart" %>
    <% Cart cart = (Cart) session.getAttribute("cart"); %>

    <p> Name : <%= cart.getName() %> </p>
    <p> Quantity : <%= cart.getQuantity() %> </p>

</body>
</html>
