<%--
  Created by IntelliJ IDEA.
  User: 25901
  Date: 2022/3/25
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑商品信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui-v2.6.8/layui/css/layui.css"  media="all">

</head>
<body>
<div class="layui-form layuimini-form">
    <%--    隐藏不可以修改id--%>
    <div class="layui-form-item layui-hide">
        <label class="layui-form-label required">商品ID</label>
        <div class="layui-input-block">
            <input type="number" name="productId" value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品名称</label>
        <div class="layui-input-block">
            <input type="text" name="productName" lay-verify="required" lay-reqtext="商品名称不能为空" placeholder="请输入商品名" value="" class="layui-input">
        </div>
    </div>
     <div class="layui-form-item">
            <label class="layui-form-label required">商铺编码</label>
            <div class="layui-input-block">
                <input type="text" name="tenantId" lay-verify="required" readonly value="" class="layui-input">
            </div>
      </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品价格</label>
        <div class="layui-input-block">
            <input type="text" name="productPrice" placeholder="请输入商品价格" value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" placeholder="请输入姓名" value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系方式</label>
        <div class="layui-input-block">
            <input type="text" name="userPhone" value="" placeholder="请输入联系方式"  class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input type="text" name="orderAddress" placeholder="请输入配送地址" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/layui-v2.6.8/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        form.render("radio", "edit-table");
        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var data1 = JSON.stringify(data.field);
            var index = layer.alert(data1, {
                title: '最终的提交信息'
            }, function () {
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: '${pageContext.request.contextPath}/addOrder',
                    data: data1,
                    contentType: 'application/json;charset=UTF-8',
                    success: function (res) {
                        //弹个提示框
                        if (res.rspCode === "0000") {
                            parent.layer.msg("成功", {icon: 6,time:1000},function () {
                                console.log(parent,'1111')
                                parent.location.reload();
                                // 关闭弹出层
                                layer.close(index);
                                var iframeIndex = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(iframeIndex);
                                //
                            });
                            // parent.location.reload()
                        }else {
                            parent.layer.msg("失败",{icon: 5});
                        }
                    },
                    error: function () {
                        layer.msg("error",{icon: 5});
                    }
                })

            });
            return false;
        });
    });
</script>
</html>
