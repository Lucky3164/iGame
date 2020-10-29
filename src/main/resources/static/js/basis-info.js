$(function () {//头像内容
    var b = $('.tx_box ul').length;
    var on = 0;
    for (i = 0; i < b; i++) {
        $('.pglis').append('<span></span>');
    }
    $('.pglis span').eq(on).addClass('on');

    var avatar = $('#avatar').val();
    avatar = parseInt(avatar);
    if (avatar && $('#tx_box ul li[data-id=' + avatar + ']').length > 0) {
        $('#tx_box ul').hide();
        $('#tx_box ul li[data-id=' + avatar + ']').addClass('on');
        $('#tx_box ul li[data-id=' + avatar + ']').parents('ul').show();
        on = $('#tx_box ul li[data-id=' + avatar + ']').parents('ul').index() - 1;
        $('.pglis span').eq(on).addClass('on').siblings().removeClass('on');
    }
    $('.btnwrap .prvebtn').click(function () {
        on--
        if (on <= 0) {
            on = 0
        }
        ;
        tx_(on);
    })
    $('.btnwrap .nextbtn').click(function () {
        on++
        if (on >= (b - 1)) {
            on = (b - 1)
        }
        ;
        tx_(on);
    })
    $('.pglis span').click(function () {
        on = $(this).index();
        tx_(on);
    });

    function tx_(on) {
        $('.tx_box ul').stop().fadeOut(function () {
            $('.tx_box ul').eq(on).show();
        });
        $('.pglis span').eq(on).addClass('on').siblings().removeClass('on');
    }

    //头像选择
    $('.tx_box ul li').on('click', function () {
        $('.tx_box ul li').removeClass('on');
        $(this).addClass('on');
        $("#avatar").val($(this).attr('data-id'));
    });
    //tips
    //选中状态
    $('.gender_wrap .radiobtn span').click(function () {
        if ($(this).hasClass('inpbg')) {
        } else {
            $('.radiobtn span').removeClass('inpbg');
            $(this).addClass('inpbg');
            $(this).prev('input').click();
        }
    });

    $('#tx_setting').click(function () {
        if ($("#tx_wrap")) {
            var tx_position = document.getElementById('tx_wrap').offsetTop
            $("body,html").animate({scrollTop: tx_position - 60}, 300);
        }
    })
    //兴趣选择
    $('.Interest_wrap .choose_btn').click(function () {
        $('.list_a').slideUp(function () {
            $('.list_c').slideDown()
        });
    })
    //兴趣修改
    $('.Interest_wrap .inte_change').click(function () {
        $('.list_b').slideUp(function () {
            $('.list_c').slideDown()
        });
    })
    $('.list_c .inte_item span').click(function () {
        if ($(this).hasClass('inte_on')) {
            $(this).removeClass('inte_on')
        } else if ($('.list_c .inte_item .inte_on').length < 5) {
            $(this).toggleClass('inte_on');
        } else {
            layer.msg('最多只能选择五个！', {time: 1000})
        }
    })
    $('.changebtn_wrap span').click(function () {
        var chooseitem = $("#personalized").val();
        if ($(this).hasClass('btn_a')) {//选择
            $('.list_b .choose_inte').empty()
            chooseitem = "";
            $('.list_c .inte_item .inte_on').each(function () {
                chooseitem += $(this).html() + "，";
                var this_bq = $(this).clone()
                this_bq.attr('class')
                $('.list_b .choose_inte').append(this_bq)
            });
            if (chooseitem != "") {
                chooseitem = chooseitem.substring(0, chooseitem.length - 1);
            }
            $("#personalized").val(chooseitem);
        }
        $(".list_b .choose_tips").remove();
        $(".list_a .choose_tips").html('<i></i>爱好最多可以选择5个标签');
        $('.list_c').slideUp(function () { //取消
            if (chooseitem == "") {
                $('.list_b').hide();
                $('.list_a').slideDown();
            } else {
                $('.list_a').hide();
                $('.list_b').slideDown();
            }
        });
    });
    //关闭弹框
    $(".tan_box .close_i").click(function () {
        $(".tan_box").hide();
        $(".tan_box .sure").unbind();
    })
    //修改名字:
    // var nober = parseInt($("#myintegral").text());
    // var upnickintegral = parseInt($("#upnickintegral").val());
    $(document).on('click', '#on_i_name', function () {
        // console.log('updateUsername');
        // $(".tan_box").show();
        // // if($("#user_level").val() < 5){
        // //     $(".tan_box p").html("您的会员等级尚未达到Lv 5，暂不能使用此功能。");
        // //     $(".tan_box .tab_list").hide();
        // //     $(".tan_box .a_more").hide();
        // // }else if(nober>=upnickintegral){
        //     $(".tan_box p").html("修改昵称需要扣除"+0+"积分");
        //     $(".tan_box .tab_list").show();
        //     $(".tan_box .a_more").hide();
        // // }else{
        // //     $(".tan_box p").html("您的积分不足<br/>无法修改昵称！！");
        // //     $(".tan_box .tab_list").hide();
        // //     $(".tan_box .a_more").show();
        // // }
        // $(document).on('click', '.tan_box .sure', function () {
        //     $(".tan_box").hide();
        $("#name_i").hide();
        $("#on_i_name").hide();
        $("#nickname").attr('type', "text");
        //     // $("#myintegral").text(nober);
        // })
        // $(document).on('click', '.tan_box .cancel', function () {
        //     $(".tan_box").hide();
        // })
        // $(".tan_box .sure").click(function(){
        //     $(".tan_box").hide();
        //     $("#name_i").hide();
        //     $("#on_i_name").hide();
        //     $("#nickname").attr('type',"text");
        //     $("#myintegral").text(nober);
        // });
        //取消
        // $(".tan_box .cancel").click(function(){
        //     $(".tan_box").hide();
        // });
    })
    // $("#on_i_name").click(function(){
    //     console.log('updateUsername');
    //     $(".tan_box").show();
    //     // if($("#user_level").val() < 5){
    //     //     $(".tan_box p").html("您的会员等级尚未达到Lv 5，暂不能使用此功能。");
    //     //     $(".tan_box .tab_list").hide();
    //     //     $(".tan_box .a_more").hide();
    //     // }else if(nober>=upnickintegral){
    //     //     $(".tan_box p").html("修改昵称需要扣除"+upnickintegral+"积分");
    //     //     $(".tan_box .tab_list").show();
    //     //     $(".tan_box .a_more").hide();
    //     // }else{
    //     //     $(".tan_box p").html("您的积分不足<br/>无法修改昵称！！");
    //     //     $(".tan_box .tab_list").hide();
    //     //     $(".tan_box .a_more").show();
    //     // }
    //     $(".tan_box .sure").click(function(){
    //         $(".tan_box").hide();
    //         $("#name_i").hide();
    //         $("#on_i_name").hide();
    //         $("#nickname").attr('type',"text");
    //         $("#myintegral").text(nober);
    //     });
    //     //取消
    //     $(".tan_box .cancel").click(function(){
    //         $(".tan_box").hide();
    //     });
    // });
    //开启中级头衔
    $("#title2.on,#title3.on,#title4.on").click(function () {
        var titlelevel = $(this).attr("id");
        var level = 2;
        var uptitleintegral = 2;
        if (titlelevel == "title3") {
            uptitleintegral = 4;
            level = 3;
        } else if (titlelevel == "title4") {
            uptitleintegral = 6;
            level = 4;
        }
        $(".tan_box").show();
        if (nober >= uptitleintegral) {
            $(".tan_box p").html("开启头衔需要扣除" + uptitleintegral + "积分");
            $(".tan_box .tab_list").show();
            $(".tan_box .a_more").hide();
        } else {
            $(".tan_box p").html("您的积分不足<br/>无法开启头衔！！");
            $(".tan_box .tab_list").hide();
            $(".tan_box .a_more").show();
        }
        $(".tan_box .sure").click(function () {
            //提交后台开启功能
            var url = "/api/opentitle";
            $.ajax({
                url: url,
                type: "POST",
                data: {level: level},
                dataType: 'json',
                success: function (data) {
                    if (data.code == 1) {
                        nober = data.integral;
                        $("#" + titlelevel).parents(".title_box").find(".title_lis").find("span").addClass("on_span");
                        $("#" + titlelevel).text("已开启")
                        $("#" + titlelevel).removeClass("on")
                        $("#" + titlelevel).unbind();
                        $("#myintegral").text(nober);
                    } else if (data.code == 121) {
                        nober = data.integral;
                        $(".clos_tips p").html('您的积分不足<br/>需要积分' + uptitleintegral + '您当前账号积分' + nober);
                        $("#myintegral").text(nober);
                    } else {
                        $(".clos_tips p").html('操作失败');
                    }
                    $(".tan_box").hide();
                }
            });
        });
        //取消
        $(".tan_box .cancel").click(function () {
            $(".tan_box").hide();
            $(".tan_box .sure").unbind();
        });
        //取消
        $(".tan_box .a_more").click(function () {
            $(".tan_box").hide();
            $(".tan_box .sure").unbind();
        });
    });
    //点击头衔
    $(".Title_warp .title_box .title_lis ").on('click', '.on_span', function () {
        $(this).addClass("span_on").siblings().removeClass("span_on")
        $(this).parents('.title_list').siblings().find(".title_lis").find("span").removeClass("span_on")
        var tex = $(this).text();
        $("#user_title").html(tex);
        $("#title").val(tex);
    });
});
//查看权限
$('.choose_wrap .radiobtn span').click(function () {
    $(this).toggleClass('inpbg');
    $(this).prev('input').click();
})

//反馈手机失败方法
function sendmobilefeed() {
    var url = "/api/mobilefeed";
    var mobile = $("#feedmobile").val();
    $.ajax({
        url: url,
        type: "POST",
        data: {mobile: mobile},
        success: function (data) {
            if (data.code == 1) {
                $(".clos_tips p").html('感谢您的反馈，</br>我们将尽快修复问题。');
            } else {
                if (typeof (data.msg) !== "undefined") {
                    $(".clos_tips p").html(data.msg);
                } else {
                    $(".clos_tips p").html('失败');
                }
            }
        }
    });
}

//切换省份
function changeprovice() {
    if (typeof (regions) == "undefined") {
        return false;
    }
    var provinceid = $("#province").val();
    var flag = 0;
    var strselect = "";
    var nowregion = regions[provinceid].children;
    $.each(nowregion, function (index, value, array) {
        strselect += '<option  value="' + value.id + '">' + value.name + '</option>';
    });
    $("#city").html(strselect);
    changecity();
}

//切换市区
function changecity() {
    if (typeof (regions) == "undefined") {
        return false;
    }
    var provinceid = $("#province").val();
    var cityid = $("#city").val();
    var flag = 0;
    var strselect = "";
    if (cityid != null && typeof (regions[provinceid].children[cityid].children) != "undefined") {
        var nowregion = regions[provinceid].children[cityid].children;
        $.each(nowregion, function (index, value, array) {
            strselect += '<option  value="' + value.id + '">' + value.name + '</option>';
        });
    }
    $("#area").html(strselect);
}

//设置保存
function set_submit() {
    $('.infowrap .tips_lis').remove()
    var nickname = $('#nickname');
    var nickstr = nickname.val();
    if (nickstr == '') {
        show_tip(nickname, '昵称不能为空', 1);
        return false;
    }
    if (nickstr.length > 50) {
        show_tip(nickname, '昵称长度必须小于50个字符', 1);
        return false;
    }
    // if($("#oldnick").val()!=nickstr && nickstr.match(/3dm_\d+$/i) != null){
    //     show_tip(nickname,'昵称不能是3DM用户+数字格式',1);
    //     return false;
    // }
    // $("#setting").submit();
    var formData = new FormData();
    formData.append("headPhoto", $('#headPhoto')[0].files[0])
    formData.append("userName", $('#nickname').val())
    $.ajax({
        url: myuserhost + '/user/updateSetting',
        type: 'POST',
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data) {
            layer.msg(data.info);
            setTimeout(function () {
                window.location.reload();
            }, 1500);
        }
    })
    //location.href = myuserhost + '/user/personalInfo';
}

// //安全保存
// function security_submit(){
//     // $('.infowrap .tips_lis').remove();
//     // var passwd = $('#passwd');
//     // if(passwd.val() != ''){
//     //     var newpasswd = $('#newpasswd');
//     //     var checknewpasswd = $('#checknewpasswd');
//     //     if(newpasswd.val() == ''){
//     //         show_tip(newpasswd,'请输入新密码',1);
//     //         return false;
//     //     }else if(checknewpasswd.val() == ''){
//     //         show_tip(checknewpasswd,'请再次输入密码',1);
//     //         return false;
//     //     }else if(newpasswd.val()!=checknewpasswd.val()){
//     //         show_tip(checknewpasswd,'两次密码不一致',1);
//     //         return false;
//     //     }
//     // }
//     // $("#security").submit();
// }

function changepic(obj) {
    //console.log(obj.files[0]);//这里可以获取上传文件的name
    var newsrc = getObjectURL(obj.files[0]);
    document.getElementById('pre_head').src = newsrc;
    $('#pre_head').css('display', 'block');
}

function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) {
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

