var g_loginuserid = 0,g_posting=0,g_repling=0,g_praising=0,g_report=0,g_pagereport=0,zhztid=0,placemsg='点评一下...',g_huifucaptcha_obj=null,g_huifucaptcha_id=0;
var g_comment_list = new Array();
var g_user_info = {uid:0,nickname:'',avatarstr:'',gender:1,regionstr:'',title:'',title_level:0};
var g_ct_order = "";
var layer_Report = null;
var gameId = -1;

$(function(){
    // init();//初始化
    gameId = $('#gid').val();
    login_user = $('#login_user_id').val();

    var Cs_W = $('#Comments_wrap').width();
    $(window).resize(function(){
        Cs_W = $('#Comments_wrap').width();
        W_resize();
    });
    W_resize();
    // if($('#zhztid').length > 0){
    //     zhztid = $('#zhztid').val();
    //     placemsg = 'E3你怎么看？';
    // }
    getPostList(1, 1);
    if($(".Ct_sel_order").length > 0){
        $(".Ct_sel_order a").click(function(){
            var ct_order = "";
            if($(this).text() === "最早"){
                ct_order = "time";
            }
            if(g_ct_order === ct_order){
                return true;
            }else{
                g_ct_order = ct_order;
                $(this).siblings().removeClass('on');
                $(this).addClass('on');
                console.log(ct_order)
                initPostList(1, ct_order);
                return true;
            }
        });
    }
});

function W_resize(){
    var Cs_W = $('#Comments_wrap').width();
    $('.Cslis_wrap .cont_w').css('width',Cs_W - 82 +'px');
    $('.Cslis_wrap .cont-name p').css('width',Cs_W - 195 +'px');
}

function getPostList(page, order) {
    var pageSize = 10;
    $.ajax({
        url: myuserhost + '/comment/list/game/' + gameId,
        type: 'POST',
        data:{
            'pageSize': pageSize,
            'pn': page,
            'order':order
        },
        success: function (data) {
            ct_getPostList_back(data, page, pageSize, order);
        }
    })
}

function ct_getPostList_back(data, pn, pageSize, order) {

    $("#Ct_totalPage").val(data.extend.ctPage.pages);
    $("#Ct_nowPage").val(pn);
    $('#Ct_total i:last-child').text(data.extend.ctCount);
    if(data.extend.ctPage.list.length > 0){
        var str = "";
        var len = data.extend.ctPage.list.length;
        console.log(order)

        for (var i = 0; i < len; i++) {
            if(order == '0'){
                str += getCommentsHtml(data.extend.ctPage.list[i], '', i + 1);
            }else{
                str += getCommentsHtml(data.extend.ctPage.list[i], '', len - i);
            }
            // g_comment_list[data.data.list[i]['id']] = data.data.list[i];
            // ct_position = data.data.list[i].position;
        }


        $("#Cslis_wrap").append(str);
        $("#Ct_norecord").remove();

    }
}

function getCommentsHtml(data, content, floor) {
    var ct_stat = data.parentComment.commentState;
    var str = '<div class="Cslis_item">';
    if (ct_stat != '1'){
        str += '<div class="ct_error">第<span>'+floor+'</span>楼评论已删除</div>';
        str += '</div>';
        return str;
    }
    str += '<div class="cont-head">';
    str += '<a href="'+getUserHome(0)+'" class="tx" target="_blank"><img src="'+data.parentComment.commentUser.hImgPath+'"/></a>';
    str += '<div class="cont-floor">第<span>'+floor+'</span>楼</div>';
    // if(typeof(data.follow) != "undefined" && data.follow == 1){
    //     str += '<div class="follow_box on" onclick="follow_personal(this, '+data.user.uid+')"></div>';
    // }else if(typeof(data.follow) == "undefined" || data.follow != -1){
        str += '<div class="follow_box" ></div>';
    // }
    str += '<div class="user_label user_uid_'+data.parentComment.commentUser.userId+'">';
    str += '<div class="user_top">';
    str += '<a href="'+getUserHome(0)+'" class="img"><img  src="'+data.parentComment.commentUser.hImgPath+'"></a>';
    str += '<div class="infor">';
    str += '<div class="namebt">';
    str += '<a class="name_">'+data.parentComment.commentUser.userName+'</a>';
    str += '</div>';
    str += '</div>';
    str += '</div>';
    str += '<div class="lis_text">';
    str += '<div class="lis"><p class="bt">关注</p><p class="number">'+0+'</p></div>';
    str += '<div class="lis"><p class="bt">粉丝</p><p class="number">'+0+'</p></div>';
    str += '<div class="lis"><p class="bt">帖子</p><p class="number">'+0+'</p></div>';
    str += '</div>';
    // if(typeof(data.follow) != "undefined" && data.follow == 1){
    //     str += '<div class="btn_follow on" onclick="follow_personal(this, '+data.user.uid+')"> 已关注</div>';
    // }else if(typeof(data.follow) == "undefined" || data.follow != -1){
        str += '<div class="btn_follow" onclick="follow_personal(this, '+0+')"> 关注ta</div>';
    // }
    str += '</div>';
    str += '</div>';
    str += '<div class="cont-name cont_w">';
    str += '<p>';
    str += '<a href="'+getUserHome(0)+'" target="_blank"><span>'+data.parentComment.commentUser.userName+'</span></a>';
    // if(typeof data.user.vip_level != "undefined" && data.user.vip_level > 0){
    //     str += '<a href="https://yeyou.3dmgame.com/vip/index" target="_blank" class="Cotilebt"><i class="ico ico3dmzy"></i>3DM自运营 VIP'+data.user.vip_level+'</a>';
    // }else if(typeof data.user.auth_level != "undefined" && data.user.auth_level > 0 && data.user.auth_level != 4){
    //     if(data.user.auth_level == 1){
    //         str += '<a href="javascript:void(0);" class="Cotilebt"><i class="ico icobj"></i>'+data.user.auth_title+'</a>';
    //     }else if(data.user.auth_level == 2){
    //         str += '<a href="javascript:void(0);" class="Cotilebt"><i class="ico icogamegf"></i>'+data.user.auth_title+'</a>';
    //     }else if(data.user.auth_level == 3){
    //         str += '<a href="javascript:void(0);" class="Cotilebt"><i class="ico ico3dmgf"></i>'+data.user.auth_title+'</a>';
    //     }
    // }else{
    //     if(typeof data.user.user_level != "undefined" && data.user.user_level > 0)
    //     {
    //         str += '<a href="https://my.3dmgame.com/integral/" target="_blank" class="Cotileusual">Lv.'+data.user.user_level+'</a>';
    //     }else{
    //         str += '<a href="https://my.3dmgame.com/integral/" target="_blank" class="Cotileusual">Lv.1</a>';
        // }
    // }
    str += '</p>';
    str += '<div class="cont-time">'+data.parentComment.commentDate+'</div>';
    str += '</div>';
    str += '<div class="cont-message cont_w">';
    var nowcontent = content!='' ? content: data.parentComment.content;
    if(nowcontent.length>=100){
        str += '<div class="cont-txt" style="max-height: 72px;">'+nowcontent+'<span class="conttxt-mor" onclick="showdetail(this)">...<span>查看更多</span></span></div>';
    }else{
        str += '<div class="cont-txt">'+nowcontent+'</div>';
    }
    str += '</div>';
    str += '<div class="cont-address cont_w">';
    if(data.parentComment.commentUser.userId == login_user){
        str += '<p>' + '<a>删除</a>' + '</p>';
    }
    str += '<div class="praise_btn">';
    // if(typeof(data.praise)!="undefined" && (data.praise==1 || data.praise==2)){
        str += '<p class="zan_cai"><i class="zan"></i><u>'+0+'</u></p>';
    // }else{
    //     str += '<p class="zan_cai" onclick="praise(this,'+data.id+',1)"><i class="zan"></i><u>'+data.goodcount+'</u></p>';
    // }
    // if(typeof(data.report)!="undefined" && data.report==1){
        str += '<p class="jingao on"><i class="ico_jingao" ></i><u>举报</u></p>';
    // }else{
    //     str += '<p class="jingao"  onclick="jingao(this,'+data.id+')"><i class="ico_jingao" ></i><u>举报</u></p>';
    // }
    str += '<div class="replybtn" onclick="showReply(this)">回复</div>';
    str += '<div class="replybtn replybtn2" onclick="showReply(this)">取消回复</div>';
    str += '</div>';
    str += '</div>';
    str += '<div class="reply_wrap cont_w">';
    str += '<input type="text" class="reply_info" value="" onfocus="this.placeholder=\'\'" onfocusout="this.placeholder=\'回复:\'" placeholder="回复:" />';
    str += '<button class="repl_btn" onclick="ct_reply(this,'+data.parentComment.commentId+')">回复</button>';
    str += '</div>';
    if(data.countReplies > 0){
        str += '<div class="floor_wrap cont_w">';
        str += getReplies(data.replies,data.parentComment.commentId, data.countReplies);
        str += '</div>';
    }
    str += '</div>';
    return str;
}

//防止js注入
function htmlEncodeJQ ( str ) {
    return $('<span/>').text( str ).html();
}

//直接回复
function ct_reply(obj,replyId) {
    if(g_repling){
        alert('发送中，请稍后。。。');
        return false;
    }
    var content = htmlEncodeJQ( $(obj).parent().find('.reply_info').val() );
    var len = content.length;
    if(len<1){
        alert("回复内容太少了");
        return false;
    }
    if(len>200){
        alert("回复内容已超出最大长度1000字");
        return false;
    }
    g_repling = 1;
    var pageurl = "";
    if(typeof(collect_pageurl) != "undefined"){
        pageurl = collect_pageurl;
    }
    g_huifucaptcha_obj = obj;
    g_huifucaptcha_id = replyId;
    var url = myuserhost + "/comment/reply/" + gameId;
    $.ajax({
        url: url,
        type: "POST",
        data: {
            'content': content,
            'parentId': replyId,
            'replyId': replyId,
        },
        success: function (data) {
            ct_reply_back(data, obj);
        },
        complete: function () {
            g_repling = 0;
        }
    });

}

//发布评论
function ct_post(type){
    if(g_posting){
        alert('发送中，请稍后。。。');
        return false;
    }
    var content = htmlEncodeJQ($("#Ct_content").val()+ ' ');//防止最后一个@好友空格去掉
    var len = content.length;
    if(len<1){
        alert("评论内容太少了");
        return false;
    }
    if(len>1000){
        alert("评论内容已超出最大长度1000字");
        return false;
    }
    g_posting = 1;
    var url = myuserhost + "/comment/reply/" + gameId;
    $.ajax({
        url: url,
        type: "POST",
        data: {
            'content': content,
        },
        success: function (data) {
            ct_post_back(data);
        },
        complete: function () {
            g_posting = 0;
        }
    });
}

function ct_post_back(data){
    if(data.code == 200){
        $("#Ct_content").val('');
        initPostList(1);
    }else if(data.code == 409){
        openlogin();
    }else{
        alert(data.info);
        if(typeof data.extend.url !== "undefined"){
            top.location.href = myuserhost + data.extend.url;
        }
    }
    return true;
}

//初始化评论列表
function initPostList(refresh, order){
    $('.Cslis_wrap').empty();
    if('time' == order){
        console.log('order by time old')
        getPostList(1, 0);
    }else{
        console.log('order by time new')
        getPostList(1, 1);
    }


}

function ct_reply_back(data, obj){
    if(data.code == 200){
        showReply($(obj).parent().parent().find('.replybtn2'));
        // if(data.checkflag){
        //     alert('回复成功，需要等待系统审核');
        //     return false;
        // }
        initPostList(1);
        // getPostList(1);
    }else if(data.code == 409){
        openlogin();
    // }else if(data.code == 207 && $("#TencentCaptcha").length > 0){
    //     $("#TencentCaptcha").attr('data-type', 'reply');
    //     $("#TencentCaptcha").click();
    }else{
        alert(data.info);
        if(typeof data.extend.url !== "undefined"){
            top.location.href = myuserhost + data.extend.url;
        }
    }
}

//回复
function showReply(obj){
    if(!$(obj).hasClass('replybtn2')){
        hide_open_reply();
        var t_wrap = $(obj).parent('.praise_btn').parent('.cont-address');
        t_wrap.find('.replybtn').toggle();
        t_wrap.next('.reply_wrap').slideDown();
    }else{
        var t_wrap = $(obj).parent('.praise_btn').parent('.cont-address');
        t_wrap.find('.replybtn').toggle();
        t_wrap.next('.reply_wrap').stop().slideUp();
    }
}

//展示隐藏的评论内容
function showdetail(obj){
    $(obj).parent().css('max-height','none');
    $(obj).remove();
}

//展示回复的隐藏楼层
function showfloor(obj){
    $(obj).parent('.floor_item').siblings('.floor_item').show();
    $(obj).parent('.floor_item').remove();
}

function getReplies(data, listId, len) {
    var i = len - 1;
    var str = '';
    $.each(data, function (key, value) {
        if(len>3 && i==len-3){
            str += '<div class="floor_item"><div class="mor_floor" onclick="showfloor(this)">重复楼层已隐藏'+(len-3)+'条</div></div>'
        }
        str += '<div class="floor_item'+(value.commentUser.userName == 'iGame官方' ? ' Official2' : '')+'"'+(i>0 && i<len-2 ? ' style="display:none;"' : (i==0 ? ' style="border-bottom: none;"' : ''))+'>';
        str += '<p>';
        str += '<a href="'+getUserHome(1)+'" target="_blank" class="name">'+value.commentUser.userName+'</a>';
        if(value.replyId != listId){
            str += ' 回复 ' + '<a href="'+getUserHome(1)+'" target="_blank" class="name">'+data[value.replyId].commentUser.userName+'</a>';
        }

        str += '<span>'+value.commentDate+'</span></p>';
        str += '<div class="repl_info">'+value.content+'</div>';
        str += '<div class="praise_btn">';
        // if(typeof(value.praise)!="undefined" && (value.praise==1 || value.praise==2)){
            str += '<p class="zan_cai"><i class="zan"></i><u>'+0+'</u></p>';
        // }else{
        //     str += '<p class="zan_cai" onclick="praise(this,'+value.id+',1)"><i class="zan"></i><u>'+value.goodcount+'</u></p>';
        // }
        // if(typeof(value.report)!="undefined" && value.report==1){
            str += '<p class="jingao on"><i class="ico_jingao" ></i><u>举报</u></p>';
        // }else{
        //     str += '<p class="jingao"  onclick="jingao(this,'+value.id+')"><i class="ico_jingao" ></i><u>举报</u></p>';
        // }
        str += '<div class="replybtn" onclick="show_reply_list(this)">回复</div>';
        str += '<div class="replybtn replybtn2" onclick="show_reply_list(this)">取消回复</div>';
        str += '</div>';
        str += '<div class="reply_wrap">';
        str += '<input type="text" class="reply_info" value="" onfocus="this.placeholder=\'\'" onfocusout="this.placeholder=\'回复:\'" placeholder="回复:" />';
        str += '<button class="repl_btn" onclick="ct_reply_list(this,'+value.commentId+','+listId+')">回复</button>';
        str += '</div>';
        str += '</div>';
        i--;
    })
    return str;
}

//楼中楼回复
function ct_reply_list(obj,replyId,parentId) {
    if(g_repling){
        alert('发送中，请稍后。。。');
        return false;
    }
    var content = htmlEncodeJQ( $(obj).parent().find('.reply_info').val() );
    var len = content.length;
    if(len<1){
        alert("回复内容太少了");
        return false;
    }
    if(len>1000){
        alert("回复内容已超出最大长度1000字");
        return false;
    }
    g_repling = 1;
    var url = myuserhost + "/comment/reply/" + gameId;
    $.ajax({
        url: url,
        type: "POST",
        data: {
            'content': content,
            'parentId': parentId,
            'replyId': replyId,
        },
        success: function (data) {
            ct_reply_list_back(data, obj);
        },
        complete: function () {
            g_repling = 0;
        }
    });
}

function ct_reply_list_back(data, obj){
    if(data.code == 200){
        show_reply_list($(obj).parent().parent().find('.replybtn2'));
        // if(data.checkflag){
        //     alert('回复成功，需要等待系统审核');
        //     return false;
        // }
        initPostList(1);
    }else if(data.code == 409){
        openlogin();
    }else{
        alert(data.info);
        if(typeof data.extend.url !== "undefined"){
            top.location.href = myuserhost + data.extend.url;
        }
    }
    return true;
}

//l楼中楼回复
function show_reply_list(obj){
    if(!$(obj).hasClass('replybtn2')){
        hide_open_reply();
        var t_wrap = $(obj).parents('.praise_btn').parents('.floor_item');
        t_wrap.find('.replybtn').toggle();
        t_wrap.find('.reply_wrap').slideDown();
    }else{
        var t_wrap = $(obj).parents('.praise_btn').parents('.floor_item');
        t_wrap.find('.replybtn').toggle();
        t_wrap.find('.reply_wrap').stop().slideUp();
    }
}

//关闭所有已展开的回复
function hide_open_reply(){
    //直接回复
    $(".cont-address .replybtn2:visible").each(function(){
        var show_wrap = $(this).parent('.praise_btn').parent('.cont-address');
        show_wrap.find('.replybtn').toggle();
        show_wrap.next('.reply_wrap').stop().slideUp();
    });
    //楼中楼回复
    $(".floor_item .replybtn2:visible").each(function(){
        var show_wrap = $(this).parents('.praise_btn').parents('.floor_item')
        show_wrap.find('.replybtn').toggle();
        show_wrap.find('.reply_wrap').stop().slideUp();
    });
}

function getUserHome(uid) {

}