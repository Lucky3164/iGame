
$(function () {
    login_user = $('#login_user_id').val();
    if(login_user != undefined){
        $('#Ct_content').attr('placeholder', '点评一下...');
    }
})

function viewscount(){
    var gid = $('#gid').val()
    // 浏览统计
    $.post("/game/countviews", {id: gid}, function(){
        return false;
    });
}

function getviews(type, id){
    if ( type == "" || id <= 0 ){
        return false;
    }
    // 获取浏览数
    $.post("/api/getviews", {type: type, id: id}, function(data){
        $(".views").html(data.nums);
    },"json");
}

function getscore(gid, pclass){
    var num = $("."+pclass+" .myscore").attr("data-sc");
    if ( gid <= 0 || num <= 0.0 || num > 10.0 ){
        layer.msg("评分异常");
        return false;
    }
    // show_score();
    // console.log(num);
    // return true;
    // 用户评分
    $.post("/game/score", {'gameId': gid, 'score': num}, function(data){
        console.log(data);
        if ( data.code == 400 ){
            openlogin();
            layer.msg(data.extend.error);
            return false;
        }
        if(data.code == 401){
            layer.msg(data.extend.error);
            return false;
        }
        // if ( data.code == 17 ){
        //     location.href="https://my.3dmgame.com/setting/binding";
        //     return false;
        // }
        layer.msg(data.extend.tips);
        show_score();
        return false;
    },"json");
}

function getAveScore(scoreList) {
    var countScore;
    $.each(scoreList, function () {
        console.log(this);
    })
}

function gethanhapply(gameid){
    if ( gameid <= 0 ){
        return false;
    }
    // 记录申请人数
    $.post("/api/gethanhapply", {gameid: gameid}, function(data){
        if ( data.code == 17 ){
            location.href="https://my.3dmgame.com/setting/binding";
            return false;
        }

        layer.msg(data.msg);
        if(data.code == 1){
            $(".applynums").html(data.plnums+'人');
        }

        return false;
    },"json");
}

function gethanhuanums(gameid){
    if ( gameid <= 0 ){
        return false;
    }
    // 获取申请人数
    $.post("/api/gethanhuanums", {gameid: gameid}, function(data){
        if(data.code == 1){
            $(".applynums").html(data.plnums+'人');
        }
        return false;
    },"json");
}

function getquest(type, gameid){
    if ( type == "" || gameid <= 0 ){
        return false;
    }

    var tags = "";
    $(".quest").each(function(){
        if ( $(this).prop("checked") )
            tags += ","+$(this).val();
    });
    tags = tags.substr(1);
    var other = $("#other").val();
    if ( tags=="" && other=="" ){
        layer.msg("请至少勾选一项或输入内容");
        return false;
    }
    if ( other.length > 40 ){
        layer.msg("请简要描述下问题");
        return false;
    }
    // 问题提交
    $.post("/api/getquestsub", {type: type, gameid: gameid, tags: tags, other: other}, function(data){
        if ( data.code == 17 ){
            location.href="https://my.3dmgame.com/setting/binding";
            return false;
        }

        layer.msg(data.msg);
        return false;
    },"json");
}
