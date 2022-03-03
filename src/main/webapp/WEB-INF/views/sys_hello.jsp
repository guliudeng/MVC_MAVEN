<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/2/17
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
    <meta charset="UTF-8">
    <title>主页</title>

</head>
<body>
 <h1>欢迎回来</h1>
<button id="btn" name="btn" onclick="qry()">查询用户信息</button>
 <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
 <script type="text/javascript">
     function qry() {
         console.log($.ajax)
         $.ajax({
             url:`${pageContext.request.contextPath}/qryUser`,
             type:"POST",
             dataType:"json",
             data:{"userName":"18726341590"},
             success:function (data) {
                 alert(data.userName)
             },
             error:function () {
                 alert("error")
             }
         })
     }
 </script>
</body>
</html>
