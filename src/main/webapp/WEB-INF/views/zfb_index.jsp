<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/9
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付宝</title>
</head>
<body>
    <h1>支付宝沙箱支付</h1>
    <form action="${pageContext.request.contextPath}/zfDemo" method="post">
        订单编号：<input type="text" name="id"/><br>
        订单金额：<input type="text" name="price"/><br>
        订单标题：<input type="text" name="title"/><br>
        <input type="submit" value="支付">
    </form>
</body>
</html>
