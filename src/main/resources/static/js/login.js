

$('.form_login input').on('keydown',function(e){
    if(e.keyCode == 13) {
        login_submit();
    }
});

//自动登录
function setautologin(obj){
    $(obj).parent().find('span').toggleClass('inpbg');
    $("#myautologin").val(obj.checked?1:0);
}
//登录验证
function login_submit(){
    var username = $('#loginname');
    var pwd = $('#loginpassword');
    $('.Tipsbox').hide();
    if(username.val() == ''){
		 
        $('.Tips-name p').html('请输入手机号或论坛账号');
        $('.Tips-name').show();
        return false;
    }else if(pwd.val() == ''){
        $('.Tips-pswd p').html('请输入密码');
        $('.Tips-pswd').show();
        return false;
    }
    $.ajax({
        url: myuserhost + '/login',
        type: 'POST',
        data: $('#login').serialize(),
        success: function (data) {
            login_submit_bk(data, myuserhost + '/user/personalInfo');
        }
    })
}

function login_submit_bk(data, url) {
    if(data.code == 400){
        if(data.extend.usernameError != undefined){
            $('#login .Tips-name p').text(data.extend.usernameError);
            $('.Tips-name').show();
            return ;
        }
        if(data.extend.passwordError != undefined){
            $('#login .Tips-pswd p').text(data.extend.passwordError);
            $('.Tips-pswd').show();
            return ;
        }
    }else if(data.code == 200){
        location.href = url;
    }
}

function login_submit_2() {
    var username = $('#loginname');
    var pwd = $('#loginpassword');
    $('.Tipsbox').hide();
    if(username.val() == ''){
        $('.Tips-name p').html('请输入手机号或论坛账号');
        $('.Tips-name').show();
        return false;
    }else if(pwd.val() == ''){
        $('.Tips-pswd p').html('请输入密码');
        $('.Tips-pswd').show();
        return false;
    }
    //
    $.ajax({
        url: myuserhost + '/login',
        type: 'POST',
        data: $('#login').serialize(),
        success: function (data) {
            login_submit_bk(data, location.href);
        }
    });

}

//QQ 登录
function qq_login(){
    if($("#myreferurl").length>0){
        var url = myuserhost + "/login/qq?referer="+encodeURIComponent($("#myreferurl").val());
    }else{
        var url = myuserhost + "/login/qq?referer="+encodeURIComponent(window.parent.location.href);
    }
    window.open(url,'_top');
}
//微信登录
function wechat_login(){
    if($("#myreferurl").length>0){
        var url = myuserhost + "/login/wechat?referer="+encodeURIComponent($("#myreferurl").val());
    }else{
        var url = myuserhost + "/login/wechat?referer="+encodeURIComponent(window.parent.location.href);
    }
    window.open(url, '_top');
}
//微博登录
function sina_login(){
    if($("#myreferurl").length>0){
        var url = myuserhost + "/login/sina?referer="+encodeURIComponent($("#myreferurl").val());
    }else{
        var url = myuserhost + "/login/sina?referer="+encodeURIComponent(window.parent.location.href);
    }
    window.open(url, '_top');
}

function openlogin() {
    if ($('#my_login_form').is(':hidden')) {
        var login = layer.open({
            type: 1,
            title: false,
            closeBtn: 1,
            shadeClose: false,
            area: ['440px', '547px'],
            content: $('#my_login_form')
        });
    }
    if ($("#my_login_form .form_login").is(':hidden')) {
        $("#my_login_form .form_login").show();
    }
    if ($("#my_login_form .form_register").is(':visible')) {
        $("#my_login_form .form_register").hide();
    }
}

function openregister() {
    if ($('#my_login_form').is(':hidden')) {
        var login = layer.open({
            type: 1,
            title: false,
            closeBtn: 1,
            shadeClose: false,
            area: ['440px', '547px'],
            content: $('#my_login_form')
        });
    }
    if ($("#my_login_form .form_login").is(':visible')) {
        $("#my_login_form .form_login").hide();
    }
    if ($("#my_login_form .form_register").is(':hidden')) {
        $("#my_login_form .form_register").show();
    }
}