<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/searchAndNavigation.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/uploader/swfobject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/uploader/jquery.uploadify.v2.1.4.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath }/widget/newlhgdialog/lhgcore.min.js"></script>
<link href="${pageContext.request.contextPath }/js/uploader/uploadify.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.as {
	font-size: 14px;
	color: #4E4E4E;
	text-decoration: none;
}
</style>

<script type="text/javascript">
        var dg = frameElement.lhgDG;
        
   function request(strParame) {
   	var args = new Object( );
   	var query = location.search.substring(1);

   	var pairs = query.split("&"); // Break at ampersand
   	for(var i = 0; i < pairs.length; i++) {
   	var pos = pairs[i].indexOf('=');
   	if (pos == -1) continue;
   	var argname = pairs[i].substring(0,pos);
   	var value = pairs[i].substring(pos+1);
   	value = decodeURIComponent(value);
   	args[argname] = value;
   	}
   	return args[strParame];
   	} 

	function save(){
		if($("#gsmc").val()==''){
			alert("请填写公司名称");
			return;
		}
		if($("#xmmc").val()==''){
			alert("请填写项目名称");
			return;
		}
		if($("#nf").val()==''){
			alert("请填写备案时间");
			return;
		}
		if(!confirm("确认保存吗？")){
			return;
		}
		var data= "cgba.gsmc="+$("#gsmc").val()+"&cgba.xmmc="+$("#xmmc").val()
		+"&cgba.nf="+$('input[name="nf"]').val()
		+"&cgba.id="+request('id')
		+"&cgba.bar="+$("#bar").val()+"&cgba.bmjbr="+$("#bmjbr").val()+"&cgba.cgzlbh="+$("#cgzlbh").val();
		//alert(data);
		$.ajax({
				type:'post',
				url:'/xxglpt/sjjs/updateCgba.do',
				data:data,
				dataType:'json',
				async:false,
				success:function(msg){
					if(Boolean(msg)){
						alert('保存成功！');
						fanhui();
					}else{
						alert('保存失败！');
					}
				}
			});	
	}
	
	function fanhui() {
		var flag=request('flag');
		parent.window.location = '/xxglpt/page/sjjs/'+flag;
 		dg.cancel();
	}
	var flagadd=false;
	var flagsc=false;
	function closeck(){
		if(flagadd&&flagsc){
			fanhui();
		}else{
			setTime('closeck()',1000);
		}
	}
	$(function(){
		var data=parent.obj;
		
		$("#gsmc").val(data.gsmc);
		$("#xmmc").val(data.xmmc);
		$("#nf").val(data.nf);
		$("#bar").val(data.bar);
		$("#bmjbr").val(data.bmjbr);
		$("#cgzlbh").val(data.cgzlbh);
		$("#nf").datebox({    
		});
	});
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>

<body onunload="fanhui()">
	<form method="post" enctype="multipart/form-data" id="formfile">
		<center>
		                <table width="100%" border="0" style="border-style: solid; border-width: 3px 1px 1px 1px;
                            border-color: #55BEEE #C0C0C0 #C0C0C0 #C0C0C0; height: 45px;" cellspacing="0"
                            cellpadding="0">
 							<tr style="height: 35px;">
                                <td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0;
                                    color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF;
                                    padding-right: 5px; vertical-align: middle;">
                                    <b><font color="#009ACD" style="font-size: 12px;">公司名称 </font></b>
                                </td>
                                <td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0;
                                    border-bottom: 1px solid #C0C0C0; text-align: left; padding-left: 10px;" colspan="3">
                                   <input type="text" id="gsmc">
                                </td>
                            </tr>
                            
                            <tr style="height: 35px;">
                                <td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0;
                                    color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF;
                                    padding-right: 5px; vertical-align: middle;">
                                    <b><font color="#009ACD" style="font-size: 12px">备案时间 </font></b>
                                </td>
                                <td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0;
                                    border-bottom: 1px solid #C0C0C0; text-align: left; padding-left: 10px;" colspan="3">
                                 <input type="text" id="nf" name="nf"  style="width: 300px;">
                                </td>
                            </tr>
                          <tr style="height: 35px;">
                                <td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0;
                                    color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF;
                                    padding-right: 5px; vertical-align: middle;">
                                    <b><font color="#009ACD" style="font-size: 12px;">备案人 </font></b>
                                </td>
                                <td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0;
                                    border-bottom: 1px solid #C0C0C0; text-align: left; padding-left: 10px;" colspan="3">
                                   <input type="text" id="bar">
                                </td>
                            </tr>
                            <tr style="height: 35px;">
                                <td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0;
                                    color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF;
                                    padding-right: 5px; vertical-align: middle;">
                                    <b><font color="#009ACD" style="font-size: 12px;">部门经办人 </font></b>
                                </td>
                                <td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0;
                                    border-bottom: 1px solid #C0C0C0; text-align: left; padding-left: 10px;" colspan="3">
                                   <input type="text" id="bmjbr">
                                </td>
                            </tr>
                            <tr style="height: 35px;">
                                <td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0;
                                    color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF;
                                    padding-right: 5px; vertical-align: middle;">
                                    <b><font color="#009ACD" style="font-size: 12px;">成果资料编号 </font></b>
                                </td>
                                <td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0;
                                    border-bottom: 1px solid #C0C0C0; text-align: left; padding-left: 10px;" colspan="3">
                                   <input type="text" id="cgzlbh">
                                </td>
                            </tr>
                            <tr style="height: 35px;">
                                <td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0;
                                    color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF;
                                    padding-right: 5px; vertical-align: middle;">
                                    <b><font color="#009ACD" style="font-size: 12px;">项目名称 </font></b>
                                </td>
                                <td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0;
                                    border-bottom: 1px solid #C0C0C0; text-align: left; padding-left: 10px;" colspan="3">
                                   <input type="text" id="xmmc">
                                </td>
                            </tr>
                            
                        </table>
		<p>
			<a href="javascript:;" onClick="save()"  class="easyui-linkbutton" iconCls="save"
				class="as" > 保存 </a> 
            <a href="#" class="easyui-linkbutton" iconCls="back" onclick="fanhui()" >返回 </a>
           </p>
		</center>
	</form>
</body>
</html>
