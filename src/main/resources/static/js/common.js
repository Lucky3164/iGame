$('#login,#login2').on('click', function() {
    var login = layer.open({
        type: 2,
        title: false,
        closeBtn: 0,
        shadeClose: true,
        area: ['390px', '460px'],
        content: ['../QZ_login/login.html', 'no']
    });
});
//评分模拟

function show_score() {
    $('.pfbox').each(function() {
        var that = $(this);
        var ypf = $(this).attr("data-dp");
        var a = $(this).find('.scorewrap');
        var b = a.find('.score');
        var c = a.find('.processingbar');
        var d = a.find('.txt');
        var w = c.children().first()
        var n = c.children().first().text();
        var h = a.find('.hover');
        //var d = c.find('span');
        var e = d.find('u');
        h.unbind("mousemove")
        h.unbind("mouseleave")
        h.unbind("click")
        if (n >= 10) {
            n == 10
        }
        var _w = c.width() * 2;
        var postion = -Math.floor(n) * _w + "px";
        if (n >= 9.8) {
            //c.css("background-positionX", -c.width()*19);
            c.addClass('p_on10');
        } else {
            //c.css("background-positionX", postion);
            c.addClass('p_on' + Math.floor(n));
        }
        if (parseInt(n) == 0) {
            w.text('')
        }
        b.children().first().css('width', n * 10 + '%')
        if (ypf != undefined && ypf != 0) {
            e.text('您的评分为' + ypf + '分');
        }
        h.mousemove(function(event) {
            if (ypf == 0 || ypf == undefined || ypf == "") {
                var x = event.offsetX;
                var f = (x / b.width()) * 10
                f = f.toFixed(1)
                e.text('您的评分为' + f + '分');
                e.attr("data-sc", f)
                $(this).children().first().css("width", x + "px")
            }
        });
        h.mouseleave(function(event) {
            if (ypf == 0 || ypf == undefined || ypf == "") {
                b.children().first().css("width", n * 10 + '%')
                e.text('您还未评分！');
            }
        });
        h.click(function() {
            if ($('.username').length >= 1 && ypf == 0) {
                var x = event.offsetX;
                var f = (x / b.width()) * 10
                f = f.toFixed(1)
                e.text('您的评分为' + f + '分');
                e.attr("data-sc", f)
                that.attr("data-dp", f)
            } else {
                e.attr("data-sc", f)
            }
        })
    })
}
show_score();
$(function() {
    $(".dj_warp_e ul li").hover(function() {
        $(this).children(".showin").fadeIn()
    }, function() {
        $(this).children(".showin").hide()
    });
})
//本文导航 背景
$('.liswrap ul li:nth-child(odd)').css('background', '#f2f2f2')
//专区首页配置
$('.pzwrap .pzlis dl').eq(0).show()
$('.pzwrap .pztab p').mouseenter(function() {
    $(this).addClass('on').siblings().removeClass('on');
    $('.pzwrap .pzlis dl').eq($(this).index()).show().siblings().hide();
    $('.pzlis dl').eq($(this).index()).find('dd').each(function() {
        if ($(this).height() > 39) {
            $(this).prev('dt').css('height', $(this).height())
        }
    })
})
$('.pzlis dl').eq(0).find('dd').each(function() {
    if ($(this).height() > 39) {
        $(this).prev('dt').css('height', $(this).height())
    }
})
$(function() {
    //专栏幻灯
    if ($('#hdsilid').length >= 1) {
        var hdlis = $('#hdsilid .bd ul li').length;
        for (i = 0; i < hdlis; i++) {
            $('#hdsilid .hd ul').append('<li></li>');
        }
        $('#hdsilid .hd ul li').css('width', 720 / hdlis)
        jQuery("#hdsilid").slide({
            mainCell: ".bd ul",
            effect: 'leftLoop',
            autoPlay: true,
            trigger: 'mouseover',
            easing: 'swing',
            delayTime: '500',
            mouseOverStop: 'true',
            pnLoop: 'true'
        });
    }
    //相关内容推送模版不一致bug，生成后可取消下面的代码
    if ($(".news_warp_g .news_warp_g").length > 0) {
        var newswarpgHtml = $(".news_warp_g .news_warp_g").html();
        $(".news_warp_g .news_warp_g").remove();
        $(".news_warp_g").html(newswarpgHtml);
    }
})
$('#pin,.pin').click(function() {
    var nav_num = $("#Comments_wrap").offset().top;
    $("body,html").animate({
        scrollTop: nav_num - 100
    }, 400);
})
function HomeScroll(a, b) {
    function g() {
        var g = $(window).scrollLeft()
            , h = $(window).scrollTop()
            , i = $(document).height()
            , j = $(window).height()
            , k = c.height()
            , l = d.height()
            , m = k > l ? f : e
            , n = k > l ? d : c
            , o = k > l ? c.offset().left + c.outerWidth(!0) - g : d.offset().left - c.outerWidth(!0) - g
            , p = k > l ? l : k
            , q = k > l ? k : l
            , r = parseInt(q - j) - parseInt(p - j);
        $(a + "," + b).removeAttr("style"),
            j > i || p > q || m > h || p - j + m >= h ? n.removeAttr("style") : j > p && h - m >= r || p > j && h - m >= q - j ? n.attr("style", "margin-top:" + r + "px;") : n.attr("style", "_margin-top:" + (h - m) + "px;position:fixed;left:" + o + "px;" + (j > p ? "top" : "bottom") + ":0;")
    }
    if ($(a).length > 0 && $(b).length > 0) {
        var c = $(a)
            , d = $(b)
            , e = c.offset().top
            , f = d.offset().top;
        $(window).resize(g).scroll(g).trigger("resize")
    }
}
$(function() {
    if (typeof (gaoxiaoyule_360) == "undefined") {
        HomeScroll(".Content_L", ".Content_R");
    }
    //点击跳转大图
    $('.Content_L .news_warp_center p > img, .content .ZLmp3 .zl_cent p > img').click(function() {
        var imgurl = $(this).attr('src');
        if ($("#abigimg").length == 0) {
            var a = document.createElement("a");
            a.setAttribute("id", "abigimg");
            a.setAttribute("href", imgurl);
            a.setAttribute("target", "_blank");
            document.body.appendChild(a);
        } else {
            $("#abigimg").attr("href", imgurl);
        }
        document.getElementById("abigimg").click();
    });
})
//h3
$('.news_warp_center>h3').each(function() {
    $(this).html('<span class="bt">' + $(this).html() + '</span>')
})
// label
$('.label_wrap .btn_more').click(function() {
    if ($(this).hasClass('on')) {
        $(this).removeClass('on');
        $('.label_wrap .item').css('max-height', '115px')
    } else {
        $(this).addClass('on');
        $('.label_wrap .item').css('max-height', 'inherit')
    }
});

//详情页面左右切换;
(function() {
        if ($(".dj_chinesemode .pagewrap .keyup_ts_text").length >= 1) {
            'use strict';
            if (typeof (Cdetail_total) == "undefined") {
                Cdetail_total = $(".pagewrap .pagination .next").prev().text();
            }
            var gkeyup_k = 0;
            var gkeyup_n = 0;
            var gkeyup_U1 = BeginUrl(location.href);
            $(document).keyup(function(event) {
                var isFocus = $("input , textarea").is(":focus");
                var e = event || window.event;
                gkeyup_k = e.keycode || e.which;
                if (gkeyup_k == 37 && isFocus == false) {
                    //left
                    PlusUrl('-');
                } else if (gkeyup_k == 39 && isFocus == false) {
                    //right
                    PlusUrl('+');
                }
                return;
            });
            function BeginUrl(u) {
                var uTmp = '';
                if (u.indexOf('_') > 0) {
                    uTmp = u.substring(0, u.indexOf('_'));
                    gkeyup_n = u.substring(u.indexOf('_') + 1, u.indexOf('.html'));
                } else {
                    uTmp = u.substring(0, u.indexOf('.html'));
                    gkeyup_n = 1;
                }
                return uTmp;
            }
            function PlusUrl(n1) {
                var nTmp = gkeyup_n;
                if (n1 == '-') {
                    nTmp--;
                } else if (n1 == '+') {
                    nTmp++;
                }
                if (nTmp <= 0) {
                    gkeyup_n = 1;
                    return;
                } else if (nTmp > Cdetail_total) {
                    gkeyup_n = Cdetail_total;
                    return;
                }
                AddUrl(nTmp);
            }
            function AddUrl(u) {
                //跳转...
                if (u === null) {
                    return;
                }
                if (u % 1 === 0 && u <= Cdetail_total) {
                    if (u <= 1) {
                        window.location.assign(gkeyup_U1 + '.html');
                    } else {
                        window.location.assign(gkeyup_U1 + '_' + u + '.html');
                    }
                } else {
                    return;
                }
            }
        }
    }
)();

$(function() {
    //合集攻略切换
    $('.ZQ_Left .hjgl .bt_top  ul li').mouseenter(function() {
        $(this).addClass('on').siblings().removeClass('on');
        var i = $(this).index()
        $(this).parents(".hjgl").find(".lis").eq(i).addClass("on_show").siblings().removeClass("on_show")
    })
    //单机专区切换左侧人物
    $(".newzqtab .new_title ul li").click(function() {
        var i = $(this).index();
        $(this).addClass("on").siblings().removeClass("on")
        $(this).parents(".newzqtab").find(".New_warp .item").eq(i).show().siblings().hide();
    })
    //专区左右下拉切换定位
    HomeScroll(".ZQ_Left", ".ZQ_right");
    //平台时间切换
    function Platform_time() {
        $(".ZQ_Left .Gminfo .info .lis li .sp2 a").eq(0).show().siblings().hide();
        $('.ZQ_Left .Gminfo .info .lis li .sp1 a').click(function() {
            $(this).addClass('on').siblings().removeClass('on');
            $(this).parents(".lis").find(".sp2 a").hide().eq($(this).index()).fadeIn()
        })
    }
    Platform_time()
    //当页面有评分时候广告变小；
    if ($(".ZQ_Left .score-box .Gmpc").length >= 1) {
        $(".ZQ_Left .score-box").addClass("clear");
        $(".ZQ_Left .score-box .img_ img").css({
            "width": "254px",
            "padding-top": "20px",
            "height": "63px",
            "objectFit": "cover"
        })
    }

})

// 增加的媒体评分
if ($(".Mediapf .Medialunbox .bd ul li").length > 1) {
    $('#Mediatext_ ul li').each(function() {
        if ($(this).find('p').text().replace(/\s+/g, "") == '') {
            $('#Mediabd ul li').eq($(this).index()).addClass('nullitem')
        }
    })
    var data_lubox = $("#Medialunbox").thumbnailImg({
        large_elem: "#Mediatext_",
        small_elem: "#Mediabd",
        left_btn: ".Medialunbox .prev",
        //小图左箭头,
        right_btn: ".Medialunbox .next",
        //小图右箭头,
        vis: 7
    });
}
;$(".Ryearprize .ul li").each(function() {
    var i = $(this).find(".lis p").length;
    if (i > 2) {
        $(this).find(".lis p:gt(1)").hide();
        $(this).find(".lis  .more").show();
        $(this).find(".lis  .more").addClass("on")
    }
});
$(".Ryearprize .ul li .lis  .more").click(function() {
    if ($(this).hasClass("on")) {
        $(this).parents(".lis").find("p").show();
        $(this).find("span").text("收起");
        $(this).removeClass("on")
    } else {
        $(this).parents(".lis").find("p:gt(1)").hide();
        $(this).find("span").text("展开");
        $(this).addClass("on")
    }
});
