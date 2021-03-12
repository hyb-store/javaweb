<%@ page import="com.hyb.domain.User" %>
<%@ page import="java.util.*" %>
<%--
3. 获取对象、List集合、Map集合的值
				1. 对象：${域名称.键名.属性名}
					* 本质上会去调用对象的getter方法

				2. List集合：${域名称.键名[索引]}

				3. Map集合：
					* ${域名称.键名.key名称}
					* ${域名称.键名["key名称"]}
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u",user);


        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        request.setAttribute("list",list);


        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);

        request.setAttribute("map",map);


    %>

    <h3>el获取对象中的值</h3>
    ${requestScope.u}  <%--com.hyb.domain.User@223da346--%>
    <br>
    <%--
        * 通过的是对象的属性来获取
            * setter或getter方法，去掉set或get，在将剩余部分，首字母变为小写。
            * setName --> Name --> name
    --%>
    ${requestScope.u.name}  <%--张三--%>
    <br>
    ${requestScope.u.age}  <%--23--%>
    <br>
    ${requestScope.u.birthday}  <%--Fri Mar 12 14:26:43 CST 2021--%>
    <br>
    ${requestScope.u.birthday.month}  <%--2--%>
    <br>
    ${requestScope.u.birStr}  <%--2021-03-12 15:13:17--%>
    <br>

    <h3>el获取List值</h3>
    ${list}<br><%--[aaa, bbb, com.hyb.domain.User@5489c51c]--%>
    ${list[0]}<br><%--aaa--%>
    ${list[1]}<br><%--bbb--%>
    ${list[10]}<br><%--越界不显示，显示空字符串--%>

    ${list[2].name}<%--张三--%>

    <h3>el获取Map值</h3>
    ${map.gender}<br><%--男--%>
    ${map["gender"]}<br><%--男--%>
    ${map.user.name}<%--张三--%>

</body>
</html>
