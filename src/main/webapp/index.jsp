<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
 --><title>广元市测绘地理信息数据服务管理系统</title>
<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="./css/Top.css" />
<link rel="stylesheet" type="text/css" href="./css/index2.css" />
<script type="text/javascript" src="./easyui/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./js/YMLib.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
<script type="text/javascript" src="./js/init.js"></script>
<script type="text/javascript" src="./js/jquery.cookie.js"></script>
<script type="text/javascript">
var c1 = true;
var c2 = true;
var c3 = true;
var c4 = true;


$(function(){
	selSes();
	selQxByUser();
	$("#index_user").html($.cookie("truename"));
	
	$("#Menu_1").addClass('now');
	$("#Menu_1,#Menu_2,#Menu_3,#Menu_4").click(function(e){
		$("#Menu_1,#Menu_2,#Menu_3,#Menu_4").removeClass('now');
		$("#" + this.id).addClass('now');
	});
    
    $("#Menu_1").click(function () {
        $("#c2,#c3,#c4").hide();
        $("#c1").show();
        if (c1){
            $("#c1f").attr("src", "page/sjjs/Menu.jsp");
        }
    });
    //menuQx();
    $(".header_content").css({"width":"100%"});
});
function selQxByUser(){
	$.ajax({
		type : "POST",
		url : "xtgl/selQxByUser.do",
		dataType : 'json',
		data :"param.roleid="+$.cookie("roleid"),
		success : function(msg){
			if(msg){
				var qx1= new Array();
				var qx2= new Array();
				var qx3= new Array();
				var qx4= new Array();
				var qx5= new Array();
				var qx6= new Array();
				var qx7= new Array();
				for(var i=0;i<msg.length;i++){
					//第一层
					if(msg[i].id.length==4) qx1.push(msg[i].id);
					//第2层
					if(msg[i].id.length==6) qx2. push(msg[i].id);
					//第3层
					if(msg[i].id.length==8) qx3. push(msg[i].id);
					//第4层
					if(msg[i].id.length==10) qx4. push(msg[i].id);
// 					if(msg[i].id.length==12) qx5. push(msg[i].id);
// 					if(msg[i].id.length==14) qx6. push(msg[i].id);
// 					if(msg[i].id.length==16) qx7. push(msg[i].id);
				}
				YMLib.Var.qx1=qx1;
				YMLib.Var.qx2=qx2;
				YMLib.Var.qx3=qx3;
				YMLib.Var.qx4=qx4;
// 				YMLib.Var.qx5=qx5;
// 				YMLib.Var.qx6=qx6;
// 				YMLib.Var.qx7=qx7;
				//$.cookie("qx1",qx1, {expires: 1});
	     		$.cookie("qx2",qx2, {expires: 1});
	     		$.cookie("qx3",qx3, {expires: 1});
	     		$.cookie("qx4",qx4, {expires: 1});
// 	     		$.cookie("qx5",qx5, {expires: 1});
// 	     		$.cookie("qx6",qx6, {expires: 1});
// 	     		$.cookie("qx7",qx7, {expires: 1});
	     	 }
		 }
	});
}

/* function menuQx(){
		$("#menu_0101").show();
		$("#c1f").attr("src", "./page/sjjs/Menu.jsp");
		flag=true;
}
 */
function edit(){
	YMLib.UI.createWindow('updatePassword', '*  修改密码', 'page/xtgl/updatePassword.jsp','updatePassword', 460,320);
}
</script>
</head>
<body id="index_layout" class="easyui-layout">
    <div data-options="region:'north',border:false" style="height: 98px;" >
		<div class="header">
			<div class="header_content">
			    <div style="position:absolute;top:15px;right:250px;color:#f2f8fe;font-family:arial;line-height:1.5em;">欢迎您：<span id="index_user"></span></div>
			    <div class="system"><a onclick="edit()" href="javascript:void(0)">修改密码</a><em>|</em>
			    	<a onclick="clearSession()" href="javascript:void(0)">退出系统</a></div>
				<ul class="nav">
					<li id="menu_0101" style="display:none;"><a id="Menu_1" href="javascript:void(0)">数据接收</a></li>
					<li id="menu_0102" style="display:none;"><a id="Menu_2" href="javascript:void(0)">数据分发</a></li>
					<li id="menu_0103" style="display:none;"><a id="Menu_3" href="javascript:void(0)">数据查询</a></li>
					<li id="menu_0104" style="display:none;"><a id="Menu_4" href="javascript:void(0)">系统管理</a></li>
				</ul> 
			</div>
		</div>
	</div>
    <div data-options="region:'center',border:'false'" style="margin: 0px; padding: 0px;overflow: hidden">
		<div id="c1" style="width:100%;height:100%;">
			<iframe id="c1f" name="c1f"  src="" frameborder='0' height='100%' width='100%'></iframe>
		</div>
		<div id="c2" style="width:100%;height:100%;display:none;">
			<iframe id="c2f" name="c2f"  src="" frameborder='0' height='100%' width='100%'></iframe>
		</div>
		<div id="c3" style="width:100%;height:100%;display:none;">
			<iframe id="c3f" name="c3f"  src="" frameborder='0' height='100%' width='100%'></iframe>
		</div>
		<div id="c4" style="width:100%;height:100%;display:none;">
			<iframe id="c4f" name="c4f"  src="" frameborder='0' height='100%' width='100%'></iframe>
		</div>
    </div>
    <div data-options="region:'south',border:false,split:false" style="height: 25px;color:#FFF;line-height: 25px; background: url(image/footerbg.gif) 0 0 repeat-x; text-align: center;overflow: hidden;">
        <p>版权所有：广元市测绘地理信息中心 &nbsp;&nbsp;&nbsp;&nbsp; 技术支持：王冬</p>
    </div>
</body>
</html>