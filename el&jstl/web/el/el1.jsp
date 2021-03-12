<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/3/11
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--isELIgnored="true" 不解析el表达式--%>
<%--
    1. 概念：Expression Language 表达式语言
    2. 作用：替换和简化jsp页面中java代码的编写
    3. 语法：${表达式}
    4. 注意：
        * jsp默认支持el表达式的。如果要忽略el表达式
            1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
            2. \${表达式} ：忽略当前这个el表达式
    5. 使用：
        1. 运算：
            * 运算符：
                1. 算数运算符： + - * /(div) %(mod)
                2. 比较运算符： > < >= <= == !=
                3. 逻辑运算符： &&(and) ||(or) !(not)
                4. 空运算符： empty
                    * 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
                    * ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
                    * ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0
        2. 获取值
                1. el表达式只能从域对象中获取值
                2. 语法：
                    1. ${域名称.键名}：从指定域中获取指定键的值
                        * 域名称：
                            1. pageScope		--> pageContext
                            2. requestScope 	--> request
                            3. sessionScope 	--> session
                            4. applicationScope --> application（ServletContext）
                        * 举例：在request域中存储了name=张三
                        * 获取：${requestScope.name}

                    2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${3 > 4} <%-- 输出：false  --%>
    \${3 > 4} <%-- 输出：${3 > 4} 加\不解析el表达式 --%>

    <hr>

    <h3>算数运算符</h3>
    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>

    <h3>逻辑运算符</h3>
    ${3 > 4  && 3 < 4}<br>
    ${3 > 4  and 3 < 4}<br>


    <h4>empty运算符</h4>
    <%

        String str = "";
        request.setAttribute("str",str);

        List list = new ArrayList();
        request.setAttribute("list",list);

    %>
    ${not empty str}<%--false--%>

    ${not empty list}<%--false--%>

</body>
</html>
