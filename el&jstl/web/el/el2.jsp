
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el2获取域中数据</title>
</head>
<body>
<%
    //在域中存储数据
    session.setAttribute("name","李四");

    request.setAttribute("name","张三");

    session.setAttribute("age","23");

    request.setAttribute("str","");

%>

<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}

${name}<%--依次从最小的域中查找是否有该键对应的值，直到找到为止 --%>
${sessionScope.name}
</body>
</html>
