
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<html>
<%--
     2. include	： 页面包含的。导入页面的资源文件
		* <%@include file="top.jsp"%>


     注释:
         1. html注释：
            <!-- -->:只能注释html代码片段
         2. jsp注释：推荐使用
            <%-- - -%>:可以注释所有
--%>
<head>
    <title>Title</title>
</head>
<body>
  <h2>页面主体信息</h2>

  <!--
        <h3>hello</h3>
  -->
  <!-- 不能注释掉
      <%
        System.out.println("hi~~~");
      %>
  -->

  <%--
      <%
        System.out.println("hi~~~");
      %>
  --%>


</body>
</html>
