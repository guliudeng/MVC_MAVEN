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
    <title></title>
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
                <form class="layui-form" action="${pageContext.request.contextPath}/registIn" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input"><p><font color="red">${msg}</font></p>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                <input type="radio" name="sex" value="男" title="男" checked>
                                <input type="radio" name="sex" value="女" title="女" >
                            </div>
                        </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">年龄</label>
                        <div class="layui-input-block">
                            <input type="text" name="age" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">角色</label>
                        <div class="layui-input-block">
                            <input type="radio" name="role" value="学生" title="学生" checked="">
                            <input type="radio" name="role" value="商家" title="商家">
                            <input type="radio" name="role" value="管理员" title="管理员" disabled="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
<%--<script>--%>
<%--    layui.use(['layer', 'element', 'form', 'layedit'], function() {--%>
<%--        var layer = layui.layer;--%>
<%--        var form = layui.form;--%>
<%--        var element = layui.element;--%>
<%--        var layedit = layui.layedit;--%>
<%--        $(function() {--%>
<%--            $("#butt").click(function() {--%>
<%--                layer.open({--%>
<%--                    type: 1,--%>
<%--                    title: "注册页面",--%>
<%--                    area: ['600px', '700px'],--%>
<%--                    offset: '20px',--%>
<%--                    content: $("#gb"),--%>
<%--                    cancel: function() {--%>
<%--                        // 你点击右上角 X 取消后要做什么--%>
<%--                        setTimeout('window.location.reload()', 1);--%>
<%--                    },--%>
<%--                    success: function() {--%>
<%--                        form.on('submit(formDemo)', function(data) {--%>

<%--                        });--%>
<%--                    }--%>
<%--                })--%>
<%--                form.render();--%>
<%--            })--%>

<%--            //验证输入的密码是否相同；--%>
<%--            $("#pass2").blur(function() {--%>
<%--                var pass1 = $("#pass1").val();--%>
<%--                var pass2 = $("#pass2").val();--%>
<%--                if(pass1 != pass2) {--%>
<%--                    layer.msg("两次输入的密码不一致", {--%>
<%--                        "icon": 2,--%>
<%--                        "time": 2000--%>
<%--                    });--%>
<%--                    $("#pass2").val("");--%>
<%--                    return false;--%>
<%--                }--%>
<%--                return true;--%>
<%--            });--%>
<%--        });--%>
<%--        //创建一个编辑器--%>
<%--        var editIndex = layedit.build('LAY_demo_editor');--%>
<%--        //自定义验证规则--%>
<%--        form.verify({--%>
<%--            title: function(value) {--%>
<%--                if(value.length < 5) {--%>
<%--                    return '标题至少得5个字符啊';--%>
<%--                }--%>
<%--            },--%>
<%--            pwd: [--%>
<%--                /^(\w){6,20}$/, '只能输入6-20个字母、数字、下划线'--%>
<%--            ],--%>
<%--            emails: [--%>
<%--                /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, '请输入正确的邮箱格式：<br>如：xxx@qq.com<br>xxx@163.com等格式'--%>
<%--            ],--%>
<%--            phones: [--%>
<%--                /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, '您的输入有误，请重新输入(中国11位手机号)'--%>
<%--            ],--%>
<%--            truename: [--%>
<%--                /^[\u4e00-\u9fa5]{2,4}$/, '您的输入有误，请输入2-4位中文'--%>
<%--            ],--%>
<%--            cardId: [--%>
<%--                /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, '请输入正确的身份证号'--%>
<%--            ],--%>
<%--            content: function(value) {--%>
<%--                layedit.sync(editIndex);--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

</html>
