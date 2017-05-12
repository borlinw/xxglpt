$(function() {
	createMenu('LeftMenu',{
		id:'menu_010201',
		title:'合同管理',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./sjff.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010202',
		title:'费用申请',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./sjff.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010203',
		title:'现金账管理',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./sjff.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010204',
		title:'薪酬管理',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./sjff.jsp'
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