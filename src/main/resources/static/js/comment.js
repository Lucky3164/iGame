//一键已读
$('.clearbtn2').on('click',function(){
    var status =confirm("确定要全部已读");
    if(!status){
        return false;
    }
    setViewFlag(0, 2);
    $('.pl_lis .info p span u').remove();
    layer.msg('全部已读');
});
$('.pl_lis .lis .bt').click(function(){
    setViewFlag($(this).parent().attr('data-ctid'), 1);
    $(this).parent('.lis').find('u').remove();
});
function setViewFlag(id, type){
    var url = myuserhost + "/api/setctview";
    $.ajax({
        url: url,
        //async:false,
        type: "POST",
        data:{id:id, type:type},
        dataType:'json',
        success: function(data){
            if(data.code !=1){
                if(typeof data.url !== "undefined"){
                    top.location.href = myuserhost + data.url;
                }
            }
        }
    });
}