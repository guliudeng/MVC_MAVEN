<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/2/17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>修改用户信息</title>
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
                <form class="layui-form" >
                    <div class="layui-form-item">
                        <label class="layui-form-label">Id</label>
                        <div class="layui-input-block">
                            <input type="text" name="userId" id="userId"    value="${sessionScope.userInfo.userId}" autocomplete="off" class="layui-input" >
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" id="userName"    placeholder="${sessionScope.userInfo.userName}" autocomplete="off" class="layui-input" onblur="isExist()"><p><font color="red">${msg}</font></p>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password"   placeholder="${sessionScope.userInfo.password}" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="text" name="sex" placeholder="${sessionScope.userInfo.sex}" title="男">
                        </div>
                    </div>
                    <%--<div class="layui-form-item">
                        <label class="layui-form-label">年龄</label>
                        <div class="layui-input-block">
                            <input type="text" name="age" required   placeholder="请输入年龄" autocomplete="off" class="layui-input">
                        </div>
                    </div>--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">角色</label>
                        <div class="layui-input-block">
                            <p>${sessionScope.userInfo.role}</p>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="upInfo()">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //……

        //如果你的 HTML 是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来进行渲染
        form.render();
    });
</script>
<script>
    function isExist() {
        var $ = layui.jquery
        $.ajax({
            url:`${pageContext.request.contextPath}/qryUser`,
            type:"POST",
            dataType:"json",
            data:{"userName":document.getElementById("userName").value},
            success:function (data) {
                alert("用户名"+data.userName+"已存在")
            },
            error:function () {

            }
        })
    }
    
    function upInfo() {
        var $ = layui.jquery
        $.ajax({
            url:'${pageContext.request.contextPath}/updateUser'
            ,type:"POST"
            ,data:JSON.stringify({"userName":'#userName'.val,"password":'#password'.val})
            ,contentType:"application/json"
            ,success: function (res) {
                alert(success)
            },
            error:function (res) {
                alert(error)
            }
        })
    }
</script>
</html>
