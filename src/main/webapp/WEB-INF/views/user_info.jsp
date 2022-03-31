<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/3/31
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>用户信息页面</title>
    <script src="http://libs.baidu.com/jqueryui/1.8.22/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/MVC_MAVEN/static/layui/layui.js"></script>
    <%--    <script type="text/javascript" src="/MVC_MAVEN/static/layui/layui.all.js"></script>--%>
    <link rel="stylesheet" href="/MVC_MAVEN/static/layui/css/layui.css" />
</head>

<body>
<div class="layui-row">
    <div class="layui-col-md6">
        <div class="layui-card">
            <div class="layui-card-body">
                <form class="layui-form" action="" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-inline">
                            <p>${sessionScope.userInfo.userName}</p>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <p>${sessionScope.userInfo.password}</p>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <p>${sessionScope.userInfo.sex}</p>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">年龄</label>
                        <p>18</p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>
