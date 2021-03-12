<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
1. 概念：JavaServer Pages Tag Library  JSP标准标签库
	* 是由Apache组织提供的开源的免费的jsp标签		<标签>

2. 作用：用于简化和替换jsp页面上的java代码

3. 使用步骤：
	1. 导入jstl相关jar包
	2. 引入标签库：taglib指令：  <%@ taglib %>
	3. 使用标签

4. 常用的JSTL标签
	1. if:相当于java代码的if语句
		1. 属性：
            * test 必须属性，接受boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下，test属性值会结合el表达式一起使用
   		 2. 注意：
       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
	2. choose:相当于java代码的switch语句
		1. 使用choose标签声明         			相当于switch声明
        2. 使用when标签做判断         			相当于case
        3. 使用otherwise标签做其他情况的声明    	相当于default

	3. foreach:相当于java代码的for语句
--%>
<html>
<head>
    <title>if标签</title>
</head>
<body>

<%--

c:if标签
    1. 属性：
        * test 必须属性，接受boolean表达式
            * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
            * 一般情况下，test属性值会结合el表达式一起使用

    2. 注意：c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签


--%>

<c:if test="true">
    <h1>我是真...</h1>
</c:if>
<br>

<%
    //判断request域中的一个list集合是否为空，如果不为null则显示遍历集合

    List list = new ArrayList();
    list.add("aaaa");
    request.setAttribute("list",list);

    request.setAttribute("number",4);

%>

<c:if test="${not empty list}">
    遍历集合...

</c:if>
<br>

<c:if test="${number % 2 != 0}">

    ${number}为奇数

</c:if>

<c:if test="${number % 2 == 0}">

    ${number}为偶数

</c:if>

</body>
</html>
