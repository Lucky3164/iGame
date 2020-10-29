$(function(){
	$("#mobile").blur(function(){
		var mobile = $('#mobile'); 
		$('#mobile').parent().find('.tips_lis').remove();
		if(mobile.val() === '') {
            show_tip(mobile, '请输入手机号', 1);
            return false;
        }else if(mobile.val().length !== 11){
		    show_tip(mobile, '请输入11位手机号', 1);
		    return false;
	    }else if(!/^[1]([3-9])[0-9]{9}$/.test(mobile.val())){
	        show_tip(mobile,'请输入正确手机号码',1);
	        return false;
	    }
	    //checkmobile(mobile,$('#mobile').val());
	});
});

//注册验证
function reg_submit(){
	$('.infowrap .tips_lis').remove();
    var vcode = $('#validate');
    var pwd = $('#passwd');
    var cpwd = $('#checkpasswd');
    var mobile = $('#mobile');
    var userName = $('#userName');
    if(mobile.val() === ''){
        show_tip(mobile,'请输入手机号',1);
        return false;
    }else if(mobile.val().substring(0,1)==="0"){
        show_tip(mobile, '请将手机号第一位"0"去掉');
        return false;
    }else if(!/^\d+$/.test(mobile.val())) {
        show_tip(mobile, '请输入正确手机号码', 1);
        return false;
    }else if(userName.val() === ''){
        show_tip(userName, '请输入用户名', 1)
    }else if(pwd.val() === ''){
    	show_tip(mobile,'',0);
        show_tip(pwd,'请输入密码',1);
        return false;
    }else if(pwd.val().length < 6 || pwd.val().length > 20){
        show_tip(pwd,'密码应为6~20位之间',1);
        return false;
    }else if(cpwd.val() === ''){
    	show_tip(mobile,'',0);
    	show_tip(pwd,'',0);
        show_tip(cpwd,'请再次输入密码',1);
        return false;
    }else if(pwd.val() !== cpwd.val()){
    	show_tip(mobile,'',0);
    	show_tip(pwd,'',0);
        show_tip(cpwd,'两次密码不一致',1);
        return false;
    }
    else if(vcode.val() === ''){
    	show_tip(mobile,'',0);
    	show_tip(pwd,'',0);
    	show_tip(cpwd,'',0);
        show_tip(vcode,'请输入验证码',1);
        return false;
    }
    // $("#register").submit();
    $.ajax({
        url: myuserhost + '/register',
        type: 'POST',
        data: $('#register').serialize(),
        success: function (data) {
            if(data.code == '200'){
                openlogin();
                layer.msg(data.info);
            }else{
                layer.msg(data.info);
            }
        }
    })
}

//验证手机号是否合法
function checkmobile(dom,mobile){
	var url="/api/checkmobile";
	var msg = "";
	$.ajax({
		url: url,
		async:false,
		type: "POST",
		data:{
            mobile:mobile
        },
		dataType:'json',
		success: function(data){
			if(data.code == 1){
			}else{
				if(data.msg != ""){
					msg = data.msg;
				}else{
					msg = "请输入正确手机号码";
				}
				show_tip(dom,msg,1);
			}
		}
	});
	return true;
}

function get_regsms(){
    if(g_regcaptcha != 1){
        alert('请先完成图片验证');
        return false;
    }
    $('.infowrap .tips_lis').remove();
    var pwd = $('#passwd');
    var cpwd = $('#checkpasswd');
    var mobile = $('#mobile'); 
    if(mobile.val() == ''){
        show_tip(mobile,'请输入手机号',1);
        return false;
    }else if(mobile.val().substring(0,1)=="0"){
        show_tip(mobile, '请将手机号第一位"0"去掉');
        return false;
    }else if(!/^\d+$/.test(mobile.val())){
        show_tip(mobile,'请输入正确手机号码',1);
        return false;
    }else if(pwd.val() == ''){
        show_tip(mobile,'',0);
        show_tip(pwd,'请输入密码',1);
        return false;
    }else if(pwd.val().length < 6 || pwd.val().length > 20){
        show_tip(pwd,'密码应为6~20位之间',1);
        return false;
    }else if(cpwd.val() == ''){
        show_tip(mobile,'',0);
        show_tip(pwd,'',0);
        show_tip(cpwd,'请再次输入密码',1);
        return false;
    }else if(pwd.val() != cpwd.val()){
        show_tip(mobile,'',0);
        show_tip(pwd,'',0);
        show_tip(cpwd,'两次密码不一致',1);
        return false;
    }
    $('#tencentcaptcha').addClass('time_bg');
    $('#tencentcaptcha').unbind('click');
    var  time =60;
    var time60 = setInterval(function(){
        time = time-1
        if(time==0){
            time= 0
        }
        $('#tencentcaptcha').html('重新发送('+time+'S)')
        if(time==0){
            clearInterval(time60)
            $('#tencentcaptcha').removeClass('time_bg'); 
            $('#tencentcaptcha').on('click',function(){
                get_regsms();
            });
        }
    },1000);
    var url="/api/sendsms";
    var areacode = $("#areacode").val();
    $.ajax({
        url: url,
        async:false,
        type: "POST",
        data:{areacode:areacode,mobile:mobile.val(),act:1},
        dataType:'json',
        success: function(data){
            if(data.code == 1){
                alert("验证码发送成功，请注意查收");
            }else{
                var msg = "";
                if(data.msg != ""){
                    msg = data.msg;
                }else{
                    msg = "验证码发送失败";
                }
                show_tip(mobile,msg,1);
            }
        },
        complete: function(){
            clearInterval(time60)
            $('#tencentcaptcha').removeClass('time_bg'); 
            $('#tencentcaptcha').on('click',function(){
                get_regsms();
            });
        }
    });
}

function callback_regcaptcha(res){
    if(res.ret === 0){
        $.ajax({
            url: myuserhost+"/api/getregcaptcha",
            async:false,
            type: "POST",
            data:{ticket:res.ticket,randstr:res.randstr},
            dataType:'json',
            success: function(data){
                if(data.code == 1){
                    g_regcaptcha = 1;
                    get_regsms();
                }else{
                    alert(data.msg);
                    return false;
                }
            }
        });
    }
}