jQuery(document).ready(function(){
    //
    jQuery(".sellul>li>a").click(function(){
        var child_show=jQuery(this).attr("child_show");
        if(child_show=="true"){
            jQuery(this).parent().find("img").attr("src","/style/system/front/default/images/usercenter/menucontract.jpg");
            jQuery(this).parent().find("ul").slideUp('normal');
            jQuery(this).attr("child_show","false");
        }else{
            jQuery(this).parent().find("img").attr("src","/style/system/front/default/images/usercenter/menuspread.jpg");
            jQuery(this).parent().find("ul").slideDown('normal');
            jQuery(this).attr("child_show","true");
        }
    });
    //
    jQuery(".sellul>ul>li").removeClass("this");
    var op = jQuery("#op").val();
    jQuery("li[op="+op+"]").addClass("this");
});
