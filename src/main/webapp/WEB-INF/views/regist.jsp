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
    <link rel="stylesheet" href="/MVC_MAVEN/static/layui/css/layui.css">
    <script src=/MVC_MAVEN/static/layui/layui.js></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body style="padding: 20px;">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>注册</legend>
</fieldset>
<p><font color="red">${msg}</font></p>
<form method="post" action="${pageContext.request.contextPath}/registIn" class="layui-elem-field layui-field-title">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="userName" name="userName" id="userName" required  lay-verify="userName" placeholder="请输入用户" autocomplete="off" class="layui-input" onblur="qry()">
        </div>
        <i class="layui-icon" style="font-size: 30px; color: #1E9FFF;"></i>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <i class="layui-icon layui-icon-password" style="font-size: 30px; color: #1E9FFF;"></i>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <div>
        <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="qry()">查询</button>
    </div>
</form>
</body>
<script type="text/javascript">
    function qry() {
        let value = document.getElementById("userName").value;
      var data = {"userName":value}
        console.log($.ajax)
        $.ajax({
            url:`${pageContext.request.contextPath}/qryUser`,
            type:"POST",
            dataType:"json",
            data:data,
            success:function (data) {
               alert("用户名"+data.userName+"已存在")
               // layer.msg("用户名"+data.userName+"已存在")
            },
            error:function () {
                alert("error")
            }
        })
    }
</script>
</html>
