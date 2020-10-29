$('#demo1').banqh({
    box: "#hdlist", //总框架
    pic: "#ban_pic1", //大图框架
    pnum: "#ban_num1", //小图框架
    autoplay: true, //是否自动播放
    interTime: 5000, //图片自动切换间隔
    delayTime: 400, //切换一张图片时间
    pop_delayTime: 400, //弹出框切换一张图片时间
    order: 0, //当前显示的图片（从0开始）
    picdire: true, //大图滚动方向（true为水平方向滚动）
    mindire: true, //小图滚动方向（true为水平方向滚动）
    min_picnum: 4, //小图显示数量
    pop_up: false //大图是否有弹出框
})

//$(function() {

//	jQuery(".picScroll").slide({

//		titCell: ".hd ul",

//		mainCell: ".bd ul",

//		autoPage: true,

//		effect: "leftLoop",

//		autoPlay: true,

//		vis: 5

//	});

//})
$(function(){

    $(".Min_1 .Min_L .pctj .lis").each(function(){
        var nober =$(this).find("span").text()
        nober = Number(nober).toFixed(1)
        $(this).find("span").text(nober)
    });

    $('.phliswrap .lis ul li').mouseenter(function(){
        $(this).addClass('on').siblings().removeClass('on');
    })


})

