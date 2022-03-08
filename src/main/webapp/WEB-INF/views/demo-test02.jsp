<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/3/8
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test03" METHOD="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"/></td>
        </tr>
        <tr>

            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
