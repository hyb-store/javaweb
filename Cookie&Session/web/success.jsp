<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/3/10
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
</body>
</html>
