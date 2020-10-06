jQuery(function(jQuery){
    jQuery(".collection a").click(function(){
        var user = {};
        user =jQuery("#user").val();
        var userId= jQuery("#userId").val();
        var storeId= jQuery("#storeId").val();
        if(user)
            if(user.id ==  userId){
            alert("不能收藏自己的店铺");
        }else{
            jQuery.post("/add_store_favorite.htm",{"id":storeId},function(data){
                if(data==0){
                    alert("店铺收藏成功！");
                }
                if(data==1){
                    alert("该店铺已经被收藏！");
                }
            },"text");
        }
    });
    //
    jQuery("span[id^=ugc_]").css("cursor","pointer").click(function(){
        var template = jQuery("#template").val();
        var ugc_type=jQuery(this).attr("ugc_type");
        var ugc_id=jQuery(this).attr("ugc_id");
        if(ugc_type=="show"){
            jQuery(this).find("img").attr("src","/style/shop/"+template+"/images/add.jpg");
            jQuery("#ugc_child_"+ugc_id).hide();
            jQuery(this).attr("ugc_type","hide");
        }else{
            jQuery(this).find("img").attr("src","/style/shop/"+template+"/images/add2.jpg");
            jQuery("#ugc_child_"+ugc_id).show();
            jQuery(this).attr("ugc_type","show");
        }
    });
    //
    jQuery(".twocoad").css("cursor","pointer").mouseover(function(){
        jQuery(".shop_botmhbox").fadeIn('fast');
    }).mouseleave(function(){
        jQuery(".shop_botmhbox").fadeOut('fast');
    });
    //
    jQuery(".shop_rank_top li").css("cursor","pointer").mouseover(function(){
        var sort_id=jQuery(this).attr("sort_id");
        jQuery(".shop_rank_top li").removeClass("this");
        jQuery(this).addClass("this");
        jQuery(".shop_rank_botm").hide();
        jQuery("#"+sort_id).show();
    });
});
