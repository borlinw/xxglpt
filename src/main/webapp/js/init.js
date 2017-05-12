window.moveTo(0,0);
window.resizeTo(window.screen.width,window.screen.height);
var c1 = true;
var c2 = true;
var c3 = true;
var c4 = true;
function edit(){
	YMLib.UI.createWindow('updatePassword', '*  修改密码', 'page/xtgl/updatePassword.jsp','updatePassword', 460,320);
}
$(function(){
	menuQx();
	$("#Menu_1,#Menu_2,#Menu_3,#Menu_4").click(function(e){
		$("#Menu_1,#Menu_2,#Menu_3,#Menu_4").removeClass('now');
		$("#" + this.id).addClass('now');
	});
    $("#Menu_1").click(function () {
        $("#c2,#c3,#c4").hide();
        $("#c1").show();
        if (c1){
            $("#c1f").attr("src", "page/sjjs/Menu.jsp");
        }
    });
    $("#Menu_2").click(function () {
        $("#c1,#c3,#c4").hide();
        $("#c2").show();
        if (c2) {
            $("#c2f").attr("src", "page/sjff/Menu.jsp");
        }
    });
    //计划管理
    $("#Menu_3").click(function () {
        $("#c1,#c2,#c4").hide();
        $("#c3").show();
        if (c3) {
            $("#c3f").attr("src", "page/sjcx/Menu.jsp");
        }
    });

    $("#Menu_4").click(function () {
        $("#c1,#c2,#c3").hide();
        $("#c4").show();
        if (c4) {
            $("#c4f").attr("src", "page/xtgl/Menu.jsp");
        }
    });
    
});

function menuQx(){
	
	//alert(22);
	var qx=getQxfromSession('qx1').split(",");
	var flag=false;
	for(var i=0;i<qx.length;i++){
		$("#menu_"+qx[i]).css("display","none");
		if($("#menu_"+qx[i]).html()!=undefined){
			$("#menu_"+qx[i]).show();
			if(flag==false){
				var url="";
				switch(qx[i].substr(qx[i].length-1)){
				case "1": url="page/sjjs/Menu.jsp";break;
				case "2": url="page/sjff/Menu.jsp";break;
				case "3": url="page/sjcx/Menu.jsp";break;
				case "4": url="page/xtgl/Menu.jsp";break;
				}
				$("#Menu_"+qx[i].substr(qx[i].length-1)).addClass('now');
				$("#c1f").attr("src", url);
				flag=true;
			}
		}
	}
}
