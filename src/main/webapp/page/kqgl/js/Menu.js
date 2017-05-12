$(function() {
	createMenu('LeftMenu',{
		id:'menu_010301',
		title:'考勤管理',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./zcwj.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010302',
		title:'考勤查询',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'../sjjs/hjch2.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010303',
		title:'外出申请',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./bgda.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010304',
		title:'出差申请',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./bgdaNoEdit.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010305',
		title:'考勤统计',
		imgSrc:'../../images/gcwj.png',
		renderTo:'left_menu1',
		href:'../sjff/sjff2.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010306',
		title:'工作记录',
		imgSrc:'../../images/gcwj.png',
		renderTo:'left_menu1',
		href:'../sjff/sjff2.jsp'
	});

	menuQx();
	$("div[id^='menu'] a").click(function(){
		$(this).css("color","#0000ee");
		$(this).parents($("div[id^='menu']")).siblings().children("a").css("color","#551a8b");
	})
});
function menuQx(){
	var qx=getQxfromSession('qx2').split(",");
	for(var i=0;i<qx.length;i++){
		if($("#menu_"+qx[i])!=null) $("#menu_"+qx[i]).show();
	}
}