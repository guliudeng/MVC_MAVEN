<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/2/17
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="<c:url value="/login"/>" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">

</form>
<a href="${pageContext.request.contextPath}/regist">注册</a>

<% request.getSession().getAttribute("user");%>
</body>
</html>
