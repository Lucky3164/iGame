$(function(){

    var plat = "";
    var year = month = 0;

    $(".plat").click(function(){
        var url = "/release/";
        plat = $(this).attr("data");
        year = $(".num").html();
        month = $(".Sale_L .on").attr("data");
        url = url+plat+year+month;
        location.href = myuserhost + url;
    });
    $(".year").click(function(){
        var url = "/release/";
        plat = $(".top_nav .as").attr("data");
        year = $(this).html();
        month = $(".Sale_L .on").attr("data");
        url = url+plat+year+month;
        location.href = myuserhost + url;
    });
    $(".month").click(function(){
        var url = "/release/";
        plat = $(".top_nav .as").attr("data");
        year = $(".num").html();
        month = $(this).attr("data");
        url = url+plat+year+month;
        location.href = myuserhost + url;
    });

})
