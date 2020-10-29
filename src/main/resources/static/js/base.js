//获取当前网址
var curPath = window.document.location.href;
//获取主机地址之后的目录
var pathName = window.document.location.pathname;
var pos = curPath.indexOf(pathName);
//获取主机地址
var localhostPath = curPath.substring(0, pos);
// //获取带"/"的项目名
// var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

// const myuserhost = localhostPath + projectName;
const myuserhost = localhostPath;

var login_user = $('#login_user_id').val();

//反馈 tips
$('.feedback').on('click', function(){
  var feedback_1 = layer.open({
		  type: 1,
		  title: false,
		  skin: 'fk_tips', //样式类名
		  closeBtn: 1, //不显示关闭按钮
		  anim: 2,
		  shadeClose: true, //开启遮罩关闭
		  content: '<div class="fedbk">反馈</div><input value="" required="required" autocomplete="off" requiredtitle="请输入收不到验证码的手机(国际区号-手机号)" patterntitle="请输入收不到验证码的手机(国际区号-手机号)" class="" type="text" name="feedmobile" id="feedmobile" placeholder="请输入收不到验证码的手机(国际区号-手机号)"><div class="clos_tips">提交</div>'
		});
	$('.clos_tips').on('click',function(){
		var msg = sendmobilefeed();
		layer.close(feedback_1)
		$('.clos_tips').unbind()
	  	var feedback_2 = layer.open({
			type: 1,
			title: false,
			skin: 'fk_tips', //样式类名
			closeBtn: 1, //不显示关闭按钮
			anim: 2,
			shadeClose: true, //开启遮罩关闭
			content: msg
		});
		$('.clos_tips').on('click',function(){layer.close(feedback_2)})
	});
});
//反馈手机失败方法
function sendmobilefeed(){
	var url="/api/mobilefeed";
	var mobile = $("#feedmobile").val();
	var msg = '<p>感谢您的反馈，</br>我们将尽快修复问题。</p><div class="clos_tips">关闭</div>';
	$.ajax({
		url: url,
		async:false,
		type: "POST",
		data:{mobile:mobile},
		dataType:'json',
		success: function(data){
			if(data.code == 1){
				msg = '<p>感谢您的反馈，</br>我们将尽快修复问题。</p><div class="clos_tips">关闭</div>';
			}else{
				if(data.msg != ""){
					msg = '<p>'+data.msg+'</p><div class="clos_tips">关闭</div>';
				} else {
					msg = '<p>反馈失败,<br/>请稍后重试。</p><div class="clos_tips">关闭</div>';
				}
			}
		}
	});
	return msg;
}
//Tips
function show_tip(dom,text,state){
	dom.parent().find('.tips_lis').remove();
	if(state===0){
		 dom.parent().append('<div class="tips_lis"><u class="dui"></u></div>');
	}else if(state===1){
		 dom.parent().append('<div class="tips_lis"><p><i></i><span class="tips_txt">'+text+'</span></p></div>');
		 dom.addClass('red_c')
	}
    dom.on('keyup',function(){
        dom.parent().find('.tips_lis').remove();
        dom.removeClass('red_c')
        dom.off('keyup');
    });
}

function user_follow_personal(obj, follow_uid){
	var act = 1;
	if($(obj).hasClass("on")){
		act = 2;
	}
	var url = myuserhost + "/api/setfollow?irefer="+encodeURIComponent(top.location.href);
	$.ajax({
		url: url,
		type: "POST",
		data:{follow_uid:follow_uid, follow_act:act},
		dataType:'json',
		success: function(data){
			if(data.code == 1){
				if($(obj).hasClass("on")){
					$(obj).html('关注');
					$(obj).removeClass("on");
				}else{
					$(obj).html('已关注');
					$(obj).addClass("on");
				}
			}else if(data.code == 9){
				openlogin();
			}
		}
	});
}

function logout_submit(url) {
	$.ajax({
		url: myuserhost + "/logout",
		success: function () {
			location.reload();
		}
	})
}