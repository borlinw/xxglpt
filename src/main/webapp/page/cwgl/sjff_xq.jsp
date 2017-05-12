<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>编辑数据分发数据</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/autocomplete/jquery.autocomplete.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/uploader/swfobject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploader/jquery.uploadify.v2.1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript">
$(function(){
	
	var data=parent.obj;
	$("#dwmc").val(data.dwmc);
	//$("#xxdz").val(data.xxdz);
	//$("#zzjgdm").val(data.zzjgdm);
	//$("#fddbr").val(data.fddbr);
	//$("#frzshm").val(data.frzshm);
	//$("#yzbm").val(data.yzbm);
	$("#jbrxm").val(data.jbrxm);
	$("#sfzhm").val(data.sfzhm);
	$("#lxdh").val(data.lxdh);
	//$("#dzyx").val(data.dzyx);
	$("#bmjgmc").val(data.bmjgmc);
	//$("#bmryxm").val(data.bmryxm);
	//$("#bmyzbm").val(data.bmyzbm);
	//$("#bmlxdh").val(data.bmlxdh);
	//$("#bmxxdz").val(data.bmxxdz);
	//$("#bmdzyx").val(data.bmdzyx);
	//$("#zgbmmc").val(data.zgbmmc);
	//$("#zgcbks").val(data.zgcbks);
	//$("#zgyzbm").val(data.zgyzbm);
	//$("#zglxdh").val(data.zglxdh);
	//$("#zgxxdz").val(data.zgxxdz);
	$("#xmly").val(data.xmly);
	$("#symd").val(data.symd);
	$("#sxsjzlmc").val(data.sxsjzlmc);
	$("#zlfwjdjsl").val(data.zlfwjdjsl);
	$("#sqsj").val(data.sqsj);
	$("#chxzzgbmyj").val(data.chxzzgbmyj);
	$("#bz").val(data.bz);
	$("#bh").val(data.bh);
	
	$("#sqsj").datebox({    
	});  
	$(".combo.datebox").css("width","100px");
	$(".combo.datebox").find("input").css("width","77px");
});


</script>
</head>
<body>

		<center>
		<table width="98%" height="60%" cellpadding="0" cellspacing="0" border="0" style="margin-top: 10px; margin-left: 13px;">
			<tr>
				<td><br />
				   <table width="595px;" border="0" height="20px;">
						<tr>
							<td style="vertical-align: middle;text-align: center;">广元市地理信息数据使用申请表</td>
						</tr>
						<tr>
							<td style="vertical-align: middle;text-align: right;">编号：<input type="text" id="bh" style="width: 120px;"/></td>
						</tr>
					</table>
					<table width="595px;" border="0"
						style="border-style: solid; border-width: 3px 1px 1px 1px; border-color: #55BEEE #C0C0C0 #C0C0C0 #C0C0C0; height: 45px;"
						cellspacing="0" cellpadding="0">
						<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF; width: 15%; padding-right: 5px;"colspan="4">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">申请人信息</font></b>
							</td>
							
						</tr>
						<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									单位名称</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="dwmc" name="dwmc" type="text"   />&nbsp;
							</td>
						</tr>
						
						
						
						<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">经办人姓名</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px;">
								<input id="jbrxm" name="jbrxm" type="text"  style="width: 80px;" />&nbsp;
							</td>
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">身份证号码</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input id="sfzhm" name="sfzhm" type="text"  style="width: 80px;" />&nbsp;
							</td>
							
						</tr>
						<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">联系电话</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px;">
								<input id="lxdh" name="lxdh" type="text"  style="width: 80px;" />&nbsp;
							</td>
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">申请时间</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="sqsj" name="sqsj" type="text" />&nbsp;
							</td>
							
						</tr>
						
					<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									保密机构名称</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="bmjgmc" name="bmjgmc" type="text"   />&nbsp;
							</td>
						</tr>
					<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF; width: 15%; padding-right: 5px;"colspan="4">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">使用广元市地理信息数据的相关内容</font></b>
							</td>
							
						</tr>	
					<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									项目来源</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="xmly" name="xmly" type="text"   />&nbsp;
							</td>
						</tr>
						<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									使用目的</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="symd" name="symd" type="text"  />&nbsp;
							</td>
						</tr>
						
						<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									所需数据
资料名称
</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="sxsjzlmc" name="sxsjzlmc" type="text"  />&nbsp;
							</td>
						</tr>
						<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									种类、范围、
精度及数量
</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
							<textarea name="zlfwjdjsl" rows="3" cols="20" id="zlfwjdjsl"
						style="border-color: Black; border-width: 1px; border-style: Solid; height: 88%; width: 99%; overflow: auto"></textarea>
								
							</td>
						</tr>
						
					
						<tr style="height: 50px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									测绘行政
主管部门
意    见
</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
							<textarea name="chxzzgbmyj" rows="3" cols="20" id="chxzzgbmyj"
						style="border-color: Black; border-width: 1px; border-style: Solid; height: 88%; width: 99%; overflow: auto"></textarea>
							
							</td>
						</tr>
						<tr style="height: 35px;">
							<td  style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: center; background-color: #F1F8FF;  padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									备注</font></b>
							</td>
							<td  colspan="3" style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
							<textarea name="bz" rows="3" cols="20" id="bz"
						style="border-color: Black; border-width: 1px; border-style: Solid; height: 88%; width: 99%; overflow: auto"></textarea>
							
							</td>
						</tr>
						
						
					</table>	
					<table width="100%" border="0"
						style=" margin-top: 20px; height: 45px;"
						cellspacing="0" cellpadding="0">
						<tr style="height: 30px;">
							<td align="center">
							<td align="center">
								
								<input type="image" name="btnCancel" id="btnCancel" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/fanhui2.GIF'" alt="返回"
								onclick="parent.$('#sjff_xq_win').window('destroy');" onmouseout="this.src='${pageContext.request.contextPath}/images/Button/fanhui1.GIF'"
								src="${pageContext.request.contextPath}/images/Button/fanhui1.GIF" style="border-width: 0px;" />
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
		</center>
</body>
</html>