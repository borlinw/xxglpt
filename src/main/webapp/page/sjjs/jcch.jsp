<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础测绘管理</title>
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
function openJcchUpdate(index){
	var data=$("#jcch_table").datagrid('getRows')[index];
	obj=data;
	YMLib.UI.createWindow('jcch_update_win','编辑基础测绘','./jcch_update.jsp','xmgl_03',680,545);
}
function openJcch(index){
	var data=$("#jcch_table").datagrid('getRows')[index];
	obj=data;
	YMLib.UI.createWindow('jcch_xq_win','查看基础测绘详情','./jcch_xq.jsp','xmgl_03',680,545);
}

function deleteJcch(_id){
	$.messager.confirm('确认', '是否确认删除所选数据？', function(r){
		if (r){
			$.ajax({
				 type : "POST",
				 url : "../../sjjs/deleteJcch.do",
				 dataType : 'json',
				 data : 'id=' +_id,
				 success : function(msg){
					 if(msg){
						 YMLib.Tools.Show('删除成功！',3000);
						 $("#jcch_table").datagrid('reload');
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
function jcchDownDoc(_id){
	window.location.href="../../sjjs/jcchDownDoc.do?jcch.id="+_id;
}
function startSearch(){
	//alert($('#test').combobox("getValue")+"|"+$('#test').combobox("getText"));
	
	$("#jcch_table").datagrid({
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
		url:'../../sjjs/selectJcchList.do',
		queryParams : {
			"jcch.chxmmc":$("#chxmmc").val(),
			"jcch.xmfbdw":$("#xmfbdw").val(),
			"jcch.kssj":$("#kssj").datebox('getValue'),
			"jcch.jssj":$("#jssj").datebox('getValue')
		},
		striped:true,
		singleSelect:false,
		columns:[[
		{
			field : 'bj',
			title : '操作',
			width : 120,
			align : 'center',
			formatter : function(value,rec,index){
				return '<a href=javascript:openJcchUpdate("'+index+'")>编辑</a>| '+
				'<a href=javascript:deleteJcch("'+rec.id+'")>删除</a>| '+
				'<a href=javascript:jcchDownDoc("'+rec.id+'")>导出</a>| '+
				'<a href=javascript:openJcch("'+index+'")>详情</a>';
			}
		},{
			field : 'hjwh',
			title : '文号',
			width : 160,
			align : 'center'
		},{
			field : 'xmfbdw',
			title : '项目发包单位',
			width : 140,
			align : 'center'
		},{
			field : 'lxdh',
			title : '联系电话',
			width : 100,
			align : 'center'
		},{
			field : 'chxmmc',
			title : '测绘项目名称',
			width : 140,
			align : 'center'
		},{
			field : 'chxmszd',
			title : '测绘项目所在地',
			width : 100,
			align : 'center'
		},{
			field : 'scdw',
			title : '项目施测单位',
			width : 140,
			align : 'center'
		},{
			field : 'wcsj',
			title : '项目完成时间',
			width : 100,
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
	$("#jcch_btn_add").click(function(){
		YMLib.UI.createWindow('jcch_add_win','添加基础测绘数据','./jcch_add.jsp','app_add',680,545);
	});
	$("#jcch_btn_search").click(function(){
		startSearch();
	});
});
</script>
<div style="width:100%;">
    <div  style="height:96px;" border="false">
	    <div id="righttop">
			<div id="p_top">当前位置>&nbsp;数据接收>&nbsp;基础测绘</div>
		</div>
		<div  style="padding-left: 10px; padding-right: 10px;">
			<fieldset style="width:99%; text-align: left; vertical-align: middle;">
 				<legend style="padding: 3px 0 3px 0; font-weight: bold; color: Gray; font-size: 12px;">
 					
 				</legend>
				<div>
					<p style="margin: 1% 0px 1% 2%;">
							<span>项目发包单位：</span>
							 <input class="combo-text validatebox-text" id="xmfbdw" style="width: 113px; height: 20px; line-height: 20px;" type="text">
							<span>测绘项目名称：</span>
							 <input class="combo-text validatebox-text" id="chxmmc" style="width: 113px; height: 20px; line-height: 20px;" type="text">
							<span>完成时间：</span>
							<input type="text" id="kssj" >
							<span>至</span>
							<input type="text" id="jssj" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <img alt="查询" src="${pageContext.request.contextPath}/images/Button/Serch01.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/Serch02.gif'"
                                onmouseout="this.src='${pageContext.request.contextPath}/images/Button/Serch01.gif' "  style="border-width:0px;cursor: hand;vertical-align: middle;" onclick="startSearch()"/>
    
                            <img alt="添加" id="jcch_btn_add" src="${pageContext.request.contextPath}/images/Button/tianjia1.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/tianjia2.gif'"
                                onmouseout="this.src='${pageContext.request.contextPath}/images/Button/tianjia1.gif' "style="border-width:0px;cursor: hand;vertical-align: middle;" />
                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
				</div>
        			
 			</fieldset>
        </div>
    </div>
    <div style="height:350px;">
    	<table id="jcch_table" width="100%"></table>
    </div>
</div>
</body>
</html>