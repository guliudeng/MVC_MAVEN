<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/2/17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>regist</title>
</head>
<body>
<p><font color="red">${msg}</font></p>
<form method="post" action="${pageContext.request.contextPath}/registIn">
    用户名:<input type="text" name="userName"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
