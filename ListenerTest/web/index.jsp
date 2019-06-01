<%--
  Created by IntelliJ IDEA.
  User: tanzhenyu
  Date: 2019-06-01
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  获取test
  <%
    application.setAttribute("test", 1);
    application.setAttribute("test", 2);
    application.removeAttribute("test");
  %>
<br>
  获取session
  <%
    session.setAttribute("session", 1);
    session.setAttribute("session", 2);
    session.removeAttribute("session");
  %>
  <br>
  request
  <%
    request.setAttribute("request", 1);
    request.setAttribute("request", 2);
    request.removeAttribute("request");
  %>
  </body>
${number}
</html>
