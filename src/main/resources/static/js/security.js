function get_updatepwdsms(){
    var mobile = $("#mobile");
    $('.infowrap .sms_tips_lis').remove();
    $(".mobile_tips tips_lis").remove();
    $('#validate_btn').addClass('time_bg');
    $('#validate_btn').unbind('click');
    var  time =60;
    var time60 = setInterval(function(){
        time = time-1
        if(time==0){
            time= 0
        }
        $('#validate_btn').html('重新发送('+time+'S)')
        if(time==0){
            clearInterval(time60)
            $('#validate_btn').removeClass('time_bg');
            $('#validate_btn').on('click',function(){
                get_updatepwdsms();
            });
        }
    },1000);
    var url="/api/senduidbindsms";
    $.ajax({
        url: url,
        async:false,
        type: "POST",
        data:{act:5},
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
            $('#validate_btn').removeClass('time_bg');
            $('#validate_btn').on('click',function(){
                get_updatepwdsms();
            });
        }
    });
}
function security_submit(){
    $('.Cont_R .tips_lis').remove()
    // var vcode = $('#validate');
    var oldpwd = $('#oldpasswd');
    var pwd = $('#newpasswd');
    var cpwd = $('#checknewpasswd');
    if(pwd.val() == ''){
        show_tip(pwd,'请输入新密码',1);
        return false;
    }else if(pwd.val().length < 6 || pwd.val().length > 20){
        show_tip(pwd,'密码应为6~20位之间',1);
        return false;
    }else if(cpwd.val() == ''){
        show_tip(cpwd,'请再次输入密码',1);
        return false;
    }else if(pwd.val() != cpwd.val()){
        show_tip(cpwd,'两次密码不一致',1);
        return false;
        // $("#security").submit();
    }
    $.ajax({
        url: myuserhost + '/user/updatePassword',
        type: "POST",
        data: $('#security').serialize(),
        success: function (data) {
            if(data.code === '200'){
                layer.msg(data.info);
                setTimeout(function () {
                    logout_submit();
                }, 1500);
            }else if(data.code ==='400'){
                show_tip(oldpwd, data.info, 1);
            }

        }
    })
}