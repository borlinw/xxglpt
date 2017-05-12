<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汇交测绘管理</title>
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

function openHjch(index){
	var data=$("#hjch_table").datagrid('getRows')[index];
	obj=data;
	YMLib.UI.createWindow('hjch_xq_win','查看汇交测绘详情','./hjch_xq.jsp','xmgl_03',680,545);
}

function hjchDownDoc(_id){
	window.location.href="../../sjjs/hjchDownDoc.do?hjch.id="+_id;
}
function startSearch(){
	//alert($('#test').combobox("getValue")+"|"+$('#test').combobox("getText"));
	
	$("#hjch_table").datagrid({
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
		url:'../../sjjs/selectHjchList.do',
		queryParams : {
			"hjch.chxmmc":$("#chxmmc").val(),
			"hjch.hjdw":$("#hjdw").val(),
			"hjch.kssj":$("#kssj").datebox('getValue'),
			"hjch.jssj":$("#jssj").datebox('getValue')
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
				return '<a href=javascript:hjchDownDoc("'+rec.id+'")>导出</a>| '+
				'<a href=javascript:openHjch("'+index+'")>详情</a>';
			}
		},{
			field : 'hjwh',
			title : '汇交文号',
			width : 160,
			align : 'center'
		},{
			field : 'hjdw',
			title : '汇交单位',
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
			title : '施测单位',
			width : 140,
			align : 'center'
		},{
			field : 'wcsj',
			title : '完成时间',
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
	
	$("#hjch_btn_search").click(function(){
		startSearch();
	});
});
</script>
<div style="width:100%;">
    <div  style="height:96px;" border="false">
	    <div id="righttop">
			<div id="p_top">当前位置>&nbsp;数据接收>&nbsp;汇交测绘</div>
		</div>
		<div  style="padding-left: 10px; padding-right: 10px;">
			<fieldset style="width:99%; text-align: left; vertical-align: middle;">
 				<legend style="padding: 3px 0 3px 0; font-weight: bold; color: Gray; font-size: 12px;">
 					
 				</legend>
				<div>
					<p style="margin: 1% 0px 1% 2%;">
							<span>汇交单位：</span>
							 <input class="combo-text validatebox-text" id="hjdw" style="width: 113px; height: 20px; line-height: 20px;" type="text">
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
    
					</p>
				</div>
        			
 			</fieldset>
        </div>
    </div>
    <div style="height:350px;">
    	<table id="hjch_table" width="100%"></table>
    </div>
</div>
</body>
</html>