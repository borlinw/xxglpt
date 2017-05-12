$(function() {
	createMenu('LeftMenu',{
		id:'menu_010101',
		title:'基础测绘',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./jcch.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010102',
		title:'成果汇交',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./hjch.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010103',
		title:'成果备案',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./cgba.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010104',
		title:'文件共享',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./wjgx.jsp'
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