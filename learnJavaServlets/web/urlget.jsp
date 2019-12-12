<%--
  Created by IntelliJ IDEA.
  User: aleksandralba
  Date: 11/12/2019
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL - GET page</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String surname =  request.getParameter("surname");
%>

<p>Hello <%=name%>, <%=surname%> !</p>

<!-- browser: http://localhost:8080/urlget.jsp?name=Alex&surname=Smith  -->

</body>
</html>
