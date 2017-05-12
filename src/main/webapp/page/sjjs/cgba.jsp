<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/css/searchAndNavigation.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Top.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/util/jquery.cookie.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/widget/newlhgdialog/lhgcore.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/widget/newlhgdialog/lhgdialog.min.js"></script>
	<script type="text/javascript" src="js/cgba.js"></script>
	<style>
		#p_top{height:33px;line-height:33px;letter-spacing:1px;text-indent:18px;background:url(${pageContext.request.contextPath}/images/jianjiao.png) 8px 0 no-repeat;}
		#righttop{height:33px;background:url(${pageContext.request.contextPath}/images/righttopbg.gif) 0 0 repeat-x;}
	</style>
	<script type="text/javascript">
		$(function(){
			var date=new Date();
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate(); 
			var m1=m;
			var y1=y-1;
			/* if(m==1){
				m1=12;
				y1=y-1;
			}else{
				m1=m-1;
				y1=y;
			} */
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
			
			showAll();
			$(".pagination-page-list").css("width","4em");
			$(".combo.datebox").css("width","107px");
			$(".combo.datebox").find("input").css("width","84px");
		});
		
		function showAll(){
			var gydw=$.cookie("unit");
			var xmmc=$("#xmmc").val();
			var kssj=$("#kssj").datebox('getValue');
			var jssj=$("#jssj").datebox('getValue');
			//alert(kssj+"---"+jssj+"---"+gydw);
			$('#datagrid').datagrid({    
			    url:'/xxglpt/sjjs/selectcgbalist.do',
			    striped:true,
			    pagination:true,
			    rownumbers:true,
			    pageNumber:1,
			    pageSize:10,
			    fitColumns:false,
			    height:$(window).height()-$(window).height()*0.22,
			    width:$(window).width()-$(window).width()*0.02,
			    queryParams: {
			    	gsmc:$("#gsmc").val(),
			    	kssj:kssj,
			    	jssj:jssj,
			    	xmmc:xmmc
				},
			    columns:[[
			        {field:'c',title:'操作',width:100,align:'center',formatter:function(value,row,index){
			        	return '<a style="text-decoration:none;color:#3399CC;" href="#" onclick="editwj('+index+')">编辑</a>| '+
			        	'<a  style="text-decoration:none;color:#3399CC;" href="/xxglpt/sjjs/downWjFile.do?cgba.xmmc='+row.xmmc
		        		+'&cgba.wjlx='+row.wjlx+ '&cgba.url='+row.url+'">查看</a>| '
		        		+'<a style="text-decoration:none;color:#3399CC;" href="#" onclick="deletewj('+index+')">删除</a>';
			        	
		        		//'<a style="text-decoration:none;color:#3399CC;" href="#" onclick="ckwj('+index+')">查看</a>    ';
			        	//else	 return '<a style="text-decoration:none;color:#3399CC;" href="#" onclick="ckwj('+index+')">查看</a>    ';
			        }},
			        {field:'xmmc',title:'项目名称',width:250,align:'center'},
			        {field:'gsmc',title:'公司名称',width:250,align:'center'},
			        {field:'nf',title:'备案时间',width:111,align:'center'},
			        {field:'wjlx',title:'文件类型',width:80,align:'center'},
			        {field:'bar',title:'备案人',width:90,align:'center'},
			        {field:'bmjbr',title:'部门经办人',width:90,align:'center'},
			        {field:'cgzlbh',title:'成果资料编号',width:111,align:'center'}/* ,
			        {field:'url',title:'存放位置',width:111,align:'center'} */
			    ]]    
			}); 
		}
		
		//添加
		function xxtztj(){
			var weatherDlg = new J.dialog( {
				id : 'id2',
				title : '成果备案添加',
				page : 'cgba_add.jsp?url='+"/xxglpt/sjjs/uploadWjFile.do"+'&flag=cgba.jsp'+'&id='+new Date().getTime(),
				width : 570,
				height : 500,
				top : 0,
				rang : true,
				resize : false,
				cover : true
			});
			weatherDlg.ShowDialog();
			return false;
		}
		//编辑
		function editwj(index){
			var data=$("#datagrid").datagrid('getRows')[index];
			obj=data;
			var weatherDlg = new J.dialog( {
				id : 'id2',
				title : '成果备案编辑',
				page : 'cgba_xg.jsp?url='+"/xxglpt/sjjs/uploadWjFile.do"+'&flag=cgba.jsp'+'&id='+data.id,
				width : 570,
				height : 400,
				top : 0,
				rang : true,
				resize : false,
				cover : true
			});
			weatherDlg.ShowDialog();
			return false;
		}
		//删除
		function deletewj(index){
			if(confirm("您确认删除吗？")){
			var data=$("#datagrid").datagrid('getRows')[index];
			$.ajax({
				type:'post',
				url:'/xxglpt/sjjs/deleteCgba.do',
				data:"cgba.id="+data.id+"&cgba.xmmc="+data.xmmc+"&cgba.wjlx="+data.wjlx+"&cgba.url="+data.url,
				dataType:'json',
				async:false,
				success:function(msg){
					if(Boolean(msg)){
						alert('删除成功！');
						showAll();
					}else{
						alert('删除失败！');
					}
				}
			});	
			}
		}
		
		var obj=new Object();
		function ckwj(index){
			var data=$("#datagrid").datagrid('getRows')[index];
			obj=data;
			YMLib.UI.createWindow('cgba_ck','成果备案详情','cgba_ck.jsp','cgba_ck',580,350);
		}
	</script>
	<style type="text/css">
<!--
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: none;
}
a:active {
 text-decoration: none;
}
/*table.datagrid-htable tr td div.datagrid-cell {padding-right:25px;}*/
-->
</style>
</head>
<body>
	<div style="text-align: left; font-size: 12px; margin: 0px;">
		<table width="99.8%" border="0" style="margin-top: 1px; margin-left: 1px;" cellspacing="0" cellpadding="0">
			<tr>
			<td>
			<div id="righttop">
						<div id="p_top">当前位置>&nbsp;数据接收>&nbsp;成果备案</div>
			</div>
	           </td>
        	</tr>
        	<tr>
        		<td align="left" style="padding-left: 10px; padding-right: 10px;">
        			<fieldset style="width:99.7%; text-align: left; vertical-align: middle;margin: 1% 0px 0px 0px;">
        				<legend style="padding: 0 0 0 0; font-weight: bold; color: Gray; font-size: 12px;">
        					<font style="color: #0866A0; font-weight: bold"></font>
        				</legend>
        				<div>
        					<p style="margin: 1% 0px 1% 2%;">
        						<span>上传时间：</span>
        							<input type="text" id="kssj" >
        							<span>至</span>
        							<input type="text" id="jssj" >
        							<span>项目名称：</span>
        							 <input class="combo-text validatebox-text" id="xmmc" style="width: 113px; height: 20px; line-height: 20px;" type="text">
        							<span>公司名称：</span>
        							 <input class="combo-text validatebox-text" id="gsmc" style="width: 113px; height: 20px; line-height: 20px;" type="text">
        							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%-- 									<input type="image" name="btnSelect" id="btnSelect" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/Serch02.gif'" alt="查询" onmouseout="this.src='${pageContext.request.contextPath}/images/Button/Serch01.gif'" src="${pageContext.request.contextPath}/images/Button/Serch01.gif" style="border-width:0px;cursor: hand;" /> --%>

                                    <img alt="查询" src="${pageContext.request.contextPath}/images/Button/Serch01.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/Serch02.gif'"
                                        onmouseout="this.src='${pageContext.request.contextPath}/images/Button/Serch01.gif' "  style="border-width:0px;cursor: hand;vertical-align: middle;" onclick="showAll()"/>
            
                                    <img alt="添加" src="${pageContext.request.contextPath}/images/Button/tianjia1.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/tianjia2.gif'"
                                        onmouseout="this.src='${pageContext.request.contextPath}/images/Button/tianjia1.gif' " onclick="xxtztj()" style="border-width:0px;cursor: hand;vertical-align: middle;" />
                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                  
                                    
                                 
        					</p>
        				</div>
        			</fieldset>
        		</td>
        	</tr>

            <tr>
                <td style="padding-top: 1%;padding-left:10px;">
				<table id="datagrid" data-options="nowrap:false">
				</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
