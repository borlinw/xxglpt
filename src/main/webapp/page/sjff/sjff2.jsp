<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据分发管理</title>
<link rel="stylesheet" type="text/css" href="../../css/Top.css" />
<link rel="stylesheet" type="text/css" href="../../css/style.css" />
<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css" />
<script type="text/javascript" src="../../easyui/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/YMLib.js"></script>
<script type="text/javascript" src="../../js/util/jquery.cookie.js"></script>
</head>
<body style="margin:0 0 0 0;overflow: hidden;">
<script type="text/javascript">
var obj;
function openSjffUpdate(index){
	var data=$("#sjff_table").datagrid('getRows')[index];
	obj=data;
	YMLib.UI.createWindow('sjff_update_win','编辑数据分发','./sjff_update.jsp','xmgl_03',680,545);
}
function openSjff(index){
	var data=$("#sjff_table").datagrid('getRows')[index];
	obj=data;
	YMLib.UI.createWindow('sjff_xq_win','查看数据分发详情','./sjff_xq.jsp','xmgl_03',680,545);
}

function deleteSjff(_id){
	$.messager.confirm('确认', '是否确认删除所选数据？', function(r){
		if (r){
			$.ajax({
				 type : "POST",
				 url : "../../sjff/deleteSjff.do",
				 dataType : 'json',
				 data : 'id=' +_id,
				 success : function(msg){
					 if(msg){
						 YMLib.Tools.Show('删除成功！',3000);
						 $("#sjff_table").datagrid('reload');
					 }else{
						 YMLib.Tools.Show('删除失败',3000);
					 }
				 },
				 error : function(){
					 YMLib.Tools.Show('服务器请求无响应！error code = 404',3000);
				 }
			});
		}
	});
}
function sjffDownDoc(_id){
	window.location.href="../../sjff/sjffDownDoc.do?sjff.id="+_id;
}
function startSearch(){
	//alert($('#test').combobox("getValue")+"|"+$('#test').combobox("getText"));
	
	$("#sjff_table").datagrid({
		border:true,
		//fit:true,
		height:$(window).height()-$(window).height()*0.22,
	    width:$(window).width()-$(window).width()*0.019,
		pagination:true,
	    rownumbers:true, 
	    pageNumber:1,
	    pageSize:10,
	    fitColumns:true,
		loadMsg:'正在加载请稍候...',
		url:'../../sjff/selectSjffList.do',
		queryParams : {
			"sjff.xmly":$("#xmly").val(),
			"sjff.dwmc":$("#dwmc").val(),
			"sjff.kssj":$("#kssj").datebox('getValue'),
			"sjff.jssj":$("#jssj").datebox('getValue') 
		},
		striped:true,
		singleSelect:false,
		columns:[[
		{
			field : 'bj',
			title : '操作',
			width : 130,
			align : 'center',
			formatter : function(value,rec,index){
				return '<a href=javascript:sjffDownDoc("'+rec.id+'")>导出</a>| '+
				'<a href=javascript:openSjff("'+index+'")>详情</a>';
			}
		},{
			field : 'dwmc',
			title : '单位名称',
			width : 160,
			align : 'center'
		},{
			field : 'jbrxm',
			title : '经办人姓名',
			width : 100,
			align : 'center'
		},{
			field : 'lxdh',
			title : '联系电话',
			width : 100,
			align : 'center'
		},{
			field : 'sqsj',
			title : '申请时间',
			width : 100,
			align : 'center'
		},{
			field : 'xmly',
			title : '项目来源',
			width : 140,
			align : 'center'
		},{
			field : 'symd',
			title : '使用目的',
			width : 100,
			align : 'center'
		},{
			field : 'sxsjzlmc',
			title : '所需数据资料名称',
			width : 140,
			align : 'center'
		},{
			field : 'zlfwjdjsl',
			title : '种类、范围、精度及数量',
			width : 140,
			align : 'center'
		}
		]]
	});
}

$(function(){
	var date=new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate(); 
	var m1=m;
	var y1=y-1;
	if(m<=9){
		m='0'+m;
	}
	if(m1<=9){
		m1='0'+m1;
	}
	if(d<=9){
		d='0'+d;
	}
	$("#kssj").datebox({    
	});  
	$("#jssj").datebox({    
	});  
	$('#jssj').datebox('setValue',  y+"-"+m+"-"+d);
	if(m1==4||m1==6||m1==9||m1==11){
		if(d==31){
			d=30;
		}
	}
	if(m1==2){
		if(d==29||d==30||d==31){
			d=28
		}
	}
	$('#kssj').datebox('setValue', y1+"-"+m1+"-"+d);
	startSearch();
	$(".pagination-page-list").css("width","4em");
	$(".combo.datebox").css("width","107px");
	$(".combo.datebox").find("input").css("width","84px");
	$("#sjff_btn_add").click(function(){
		YMLib.UI.createWindow('sjff_add_win','添加数据分发数据','./sjff_add.jsp','app_add',680,545);
	});
	$("#sjff_btn_search").click(function(){
		startSearch();
	});
});
</script>
<div style="width:100%;">
    <div  style="height:96px;" border="false">
	    <div id="righttop">
			<div id="p_top">当前位置>&nbsp;数据接收>&nbsp;数据分发</div>
		</div>
		<div  style="padding-left: 10px; padding-right: 10px;">
			<fieldset style="width:99%; text-align: left; vertical-align: middle;">
 				<legend style="padding: 3px 0 3px 0; font-weight: bold; color: Gray; font-size: 12px;">
 					
 				</legend>
				<div>
					<p style="margin: 1% 0px 1% 2%;">
							<span>申请单位：</span>
							 <input class="combo-text validatebox-text" id="dwmc" style="width: 113px; height: 20px; line-height: 20px;" type="text">
							<span>项目来源：</span>
							 <input class="combo-text validatebox-text" id="xmly" style="width: 113px; height: 20px; line-height: 20px;" type="text">
							<span>申请时间：</span>
							<input type="text" id="kssj" >
							<span>至</span>
							<input type="text" id="jssj" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <img alt="查询" src="${pageContext.request.contextPath}/images/Button/Serch01.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/Serch02.gif'"
                                onmouseout="this.src='${pageContext.request.contextPath}/images/Button/Serch01.gif' "  style="border-width:0px;cursor: hand;vertical-align: middle;" onclick="startSearch()"/>
    
					</p>
				</div>
        			
 			</fieldset>
        </div>
    </div>
    <div style="height:350px;">
    	<table id="sjff_table" width="100%"></table>
    </div>
</div>
</body>
</html>