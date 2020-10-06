jQuery(function (jQuery) {
    var user = {};
    user =jQuery("#user").val();
    var storeId= jQuery("#storeId").val();
    jQuery(".top_sc").click(function () {
        console.log('hello1');
        if(user){
            if(user.storeId == storeId){
                alert("不能收藏自己的店铺");
            }else{
                console.log('hello2='+storeId);
                jQuery.post("/add_store_favorite.htm", {"id": storeId}, function (data) {
                    if (data == 0) {
                        alert("店铺收藏成功！");
                    }
                    if (data == 1) {
                        alert("该店铺已经被收藏！");
                    }
                }, "text");
            }
        }
    });

    jQuery(".top_shop_seacher input[type=button]").click(function () {
        console.log('搜索单击事件----');
        var search_area = jQuery(this).attr("search_area");
        if (search_area == "site") {
            jQuery("#store_top_search_form").attr("action", "/search.htm");
        }
        if (search_area == "store") {
            jQuery("#store_top_search_form").attr("action", "/store_goods_search.htm");
        }
        jQuery("#store_top_search_form").submit();
    });
    jQuery(".top_nofilter").mouseover(function () {
        jQuery(".top_b").hide();
        jQuery(".top_b2").show();
        jQuery(".top_sear_bom").fadeIn("normal");
    })
    jQuery(".top_search_left").css("cursor", "pointer").mouseleave(function () {
        jQuery(".top_b").show();
        jQuery(".top_b2").hide();
        jQuery(".top_sear_bom").fadeOut("normal");
    });
});
