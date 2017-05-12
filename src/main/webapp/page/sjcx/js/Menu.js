$(function() {
	createMenu('LeftMenu',{
		id:'menu_010301',
		title:'基础测绘',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./zcwj.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010302',
		title:'成果汇交',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'../sjjs/hjch2.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010303',
		title:'成果备案',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./bgda.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010304',
		title:'文件共享',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./bgdaNoEdit.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010305',
		title:'数据分发',
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