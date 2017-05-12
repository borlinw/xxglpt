//登录专用js
var bl = false;
var name;
var password;
function checkText(){
	name = $("#name").val();
	password = $("#password").val();
	if(name == ""){
		alert(' 用户名不能为空！');
		$("#name").focus();
		return;
	}else if(password == ""){
		alert(' 密码不能为空！');
		$("#password").focus();
		return;
	}
	bl = true;
}

//点击登录按钮时
function login(){
	checkText();//检查文本框是否输入
	if(bl){
		$.ajax({
			type : "POST",
			url : "xtgl/login.do",
			dataType : 'json',
			data :"master.truename="+name+"&master.password="+password,
			success : function(msg){
				if(msg){
		     		$.cookie("truename",msg.TRUENAME, {expires: 1});//将用户名放入cookie中
		     		$.cookie("unit",msg.UNIT, {expires: 1});
		     		$.cookie("roleid",msg.ROLEID, {expires: 1});
		     		document.location.href="./index.jsp";
		     		//$('#index_layout').css('visibility', 'visible');
		     	 }
		     	 else{
		     		alert("用户名或密码不正确！！");
		     	 }
			 },
			 error : function(){
				 YMLib.Tools.Show('服务器请求无响应！error code = 404',3000);
			 }
		});
	}
	
}

function loginCheck(name){
		$.ajax({
			type : "POST",
			url : "xtgl/loginCheck.do",
			dataType : 'json',
			data :"master.truename="+name,
			success : function(msg){
				if(msg){
		     		$.cookie("truename",msg.TRUENAME, {expires: 1});//将用户名放入cookie中
		     		$.cookie("unit",msg.UNIT, {expires: 1});
		     				     		
		     		$.cookie("dist2",dist2, {expires: 1});
		     		
		     		$.cookie("roleid",msg.ROLEID, {expires: 1});
		     		selQxByUser();
		     	 }
			 },error : function(){
				 YMLib.Tools.Show('服务器请求无响应！error code = 404',3000);
			 }
		});
}

function selSes(type){
	$.ajax({
		 type : "POST",
		 url : "xtgl/selQx.do",
		 dataType : 'json',
	     success : function(msg){
	    	 if(msg){
	    		 //var qx = ","+msg.resourceid+",";
	    		//$.cookie("QX",qx, {expires: 1});//设置权限
	    		// loadMenu(qx);
	    	 }else{
	    		 alert("登录超时，请重新登录！");
	    		 document.location.href="./login.html";
	     	 }
		  },
		 error : function(){
			 YMLib.Tools.Show('服务器请求无响应！error code = 404',3000);
		 }
	});
}
/**
 * 退出系统时清除session
 */
function clearSession(){
	$.ajax({
		 type : "POST",
		 url : "xtgl/clearSession.do",
		 dataType : 'json',
	     success : function(msg){
	    	 document.location.href="login.html";
		  },
		 error : function(){
			 YMLib.Tools.Show('服务器请求无响应！error code = 404',3000);
		 }
	});
}
