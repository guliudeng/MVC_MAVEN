<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/4
  Time: 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员订单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui-v2.6.8/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide "  id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
    <%-- <div class="layui-btn-container">
         <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
         <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
         <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
     </div>--%>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <input type="text" id="userName" name="userName" class="layui-input" placeholder="请输入要查询的订单用户" autocomplete="off">
        </div>
        <button class="layui-btn layui-btn-md layui-btn-normal" lay-submit lay-filter="queryUser">查询</button>
    </div>
</script>
<%--覆盖原有layui样式，完全显示图片--%>
<style type="text/css">
    .layui-table-cell{
        text-align:center;
        height: auto;
        white-space: normal;
    }
    .layui-table img{
        max:300px
    }
</style>


<script type="text/html" id="barDemo">

   <%-- <a class="layui-btn layui-btn-xs" lay-event="edit">更新订单状态</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>

</script>
<script type="text/html" id="imgtmp">
    <img src="{{d.productPhoto}}" style="width: 108px;height: 100px">
</script>


<script src="${pageContext.request.contextPath}/static/layui-v2.6.8/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;
        $ = layui.jquery

        table.render({
            elem: '#test'//id选择器，选择表格id为test的对象
            ,url:'${pageContext.request.contextPath}/qryOrder'
            ,parseData:function (res) {
                return {
                    "code": res.rspCode, //解析接口状态
                    "msg": res.rspDesc, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.rows //解析数据列表
                };
            }
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,cols: [[
                // {type:'checkbox'}//添加复选框
                {field:'orderId', width:80, title: '订单ID', sort: true}
                ,{field:'productName', width:150, title: '商品名称'}
                ,{field:'productPrice', width:80, title: '商品价格'}
                //,{field:'productPhoto',  title: '图片', templet:"#imgtmp"}
                // ,{field:'sign', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'productNum', width:80,title: '商品数量'}
                ,{field:'userName',width:100, title: '用户名'}
                ,{field:'userPhone',width:150, title: '用户号码'}
                ,{field:'orderAddress',width:150, title: '订单地址'}
                ,{field:'orderStatus',width:80, title: '订单状态'}
                ,{field:'createTime',minWidth:150, title: '创建时间'}
                ,{field: 'right' ,width: 178, align:'center', toolbar: '#barDemo'}//添加操作选项
            ]]
            ,skin: 'line' //表格风格
            ,page: true
        });
        //监听表格复选框选择，需要表格配置属性lay-filter = test ,监听表格容器id为test的事件
        table.on('checkbox(test)', function(obj){
            console.log(obj)
        });
        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    var data = checkStatus.data;
                    // layer.alert("添加商品");
                    layer.open({
                        type: 2,
                        title: '添加商品信息',
                        maxmin: true,
                        area: ['420px', '530px'],
                        shadeClose: false, //点击遮罩关闭
                        content: '${pageContext.request.contextPath}/addProduct'
                        /*  success:function (layero,index) {
                              //子窗口的body
                              var  body = layer.getChildFrame('body',index);
                              body.find("input[name=productId]").val(data.productId);
                              body.find("input[name=productName]").val(data.productName);
                              body.find("input[name=productPrice]").val(data.productPrice);
                              body.find("input[name=productPhoto]").val(data.productPhoto);
                              body.find("input[name=productType]").val(data.productType);
                              body.find("input[name=productStatus]").val(data.productStatus);

                          }*/
                    });
                    break;
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    /* obj.del();//删除对应行（tr）的DOM结构，并更新缓存
                     layer.close(index);*/
                    //向服务端发送删除指令
                    $.ajax({
                        url: '${pageContext.request.contextPath}/deleteProduct',
                        type: "POST",
                        data:{"productId":data.productId},
                        success: function (res) {
                            console.log(res)
                            if (res.rspCode = "0000") {
                                //删除这一行
                                obj.del();
                                //关闭弹框
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                                //删除成功重新调查询接口，刷新表单
                                table.reload('test',{});
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }
                    });
                    return false;
                });
            } else if(obj.event === 'edit'){
                /*  layer.prompt({
                      formType: 2
                      ,value: data.userName
                  }, function(value, index){
                      obj.update({
                          userName: value
                          ,
                      });
                      layer.close(index);
                  });*/
                layer.open({
                    type: 2,
                    title: '修改商品信息',
                    maxmin: true,
                    area: ['420px', '530px'],
                    shadeClose: false, //点击遮罩关闭
                    content: '${pageContext.request.contextPath}/editProduct',
                    success:function (layero,index) {
                        //子窗口的body
                        var  body = layer.getChildFrame('body',index);
                        body.find("input[name=productId]").val(data.productId);
                        body.find("input[name=productName]").val(data.productName);
                        body.find("input[name=productPrice]").val(data.productPrice);
                        body.find("input[name=productPhoto]").val(data.productPhoto);
                        body.find("input[name=productType]").val(data.productType);
                        body.find("input[name=productStatus]").val(data.productStatus);

                    }
                });

            }
        });
        //有关重载
        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('idTest', {
                    where: {
                        key: {
                            field: demoReload.val()
                        }
                    }
                });
            }
        };

    });
</script>

</body>
</html>
