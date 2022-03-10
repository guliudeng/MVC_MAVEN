<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/3/9
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<p>
    ${msg}
</p>
<form action="${pageContext.request.contextPath}/loginIn" method="post" class="login">
    <input type="text" name="userName" placeholder="用户名"><br>
    <input type="password" name="password" placeholder="密 码"><br>
    <input type="submit" name="login" value="登录" class="btn">
</form>
</body>
</html>
