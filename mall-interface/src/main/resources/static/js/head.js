jQuery(document).ready(function(){
    jQuery(".toph_bgsear li").mouseover(function(){
        jQuery(".toph_bgsear>li").show();
    }).mouseleave(function(){
        jQuery(".toph_bgsear>li").last().hide();
    }).click(function(){
        var index=jQuery(this).index();
        if(index==1){
            var f_text=jQuery(".toph_bgsear li").find("a").first().text();
            jQuery(".toph_bgsear li").find("a").first().html(jQuery(this).find("a").text()+"<s></s>");
            jQuery(".toph_bgsear li").find("a").last().text(f_text);
            jQuery("#type").val(jQuery(this).attr("type"));
            jQuery(".toph_bgsear>li").last().hide();
        }
    });

    jQuery(".two_code_a").click(function(){
        jQuery(this).parent().remove();
    });
});
function search_form(){
    var keyword=arguments[0];
    var type=arguments[1];
    if(keyword != "" && keyword!=undefined){
        jQuery("#keyword").val(keyword);
    }
    if(type!=""&&type!=undefined){
        jQuery("#type").val(type);
    }
    jQuery("#searchForm").submit();
    jQuery("#keyword").val("");
}
