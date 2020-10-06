jQuery(document).ready(function() {
    jQuery(".users_menu>li>em>a").mouseover(function () {
        jQuery(".users_menu>li").removeClass();
        jQuery(this).parent().parent().addClass("hover_use");
        jQuery("div[class=users_navh]").hide();
        jQuery(this).parent().parent().find("div[class=users_navh]").show();
    })
    jQuery(".users_menu>li").mouseleave(function () {
        jQuery("div[class=users_navh]").hide();
        jQuery(".users_menu>li").removeClass();
    });
    jQuery("#search_type").mouseover(function () {
        var clz = jQuery(this).attr("class");
        if (clz == "sear_type") {
            jQuery(this).attr("class", "sear_type active");
        }
        jQuery(this).find("ul li").show();
    }).mouseleave(function () {
        jQuery(this).attr("class", "sear_type");
        jQuery(this).find("ul li").hide();
        jQuery(this).find("ul li:first").show();
    });

    jQuery(".sear_type").find("ul li").click(function () {
        var type = jQuery(this).attr("type");
        jQuery("#type").val(type);
        var ht = jQuery(this).find("a").html();
        jQuery(this).parent().find("li:first").html(ht);
        jQuery(this).parent().find("li").hide();
        jQuery(this).parent().find("li:first").show();
    });

    jQuery(".user_ser_btn").click(function () {
        var type = jQuery("#type").val();
        if (type == "") {
            jQuery("#type").val("goods");
        }
        jQuery("#SearchForm").submit();
    });
});
