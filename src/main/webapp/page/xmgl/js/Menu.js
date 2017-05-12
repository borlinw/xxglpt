$(function() {
	createMenu('LeftMenu',{
		id:'menu_010101',
		title:'项目管理',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./jcch.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010102',
		title:'项目查询',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./hjch.jsp'
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