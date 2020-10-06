jQuery(document).ready(function(){
    jQuery(".navul a").each(function(){
        var original_url=jQuery(this).attr("original_url");
        var current_url =jQuery("#current_url").val();
        if(current_url.indexOf(original_url)>=0){
            jQuery(this).addClass("this");
        }
    });
    jQuery(".left_menu_dl").mouseover(function(){
        var child_count = jQuery(this).attr("child_count");
        var sc_id=jQuery(this).attr("id");
        var sc_color=jQuery(this).attr("sc_color");
        var eq =jQuery(this).index();
        var lengthArr=$(".left_menu_dl");
        var arrs=[];
        for(var i=0;i<lengthArr.length;i++){
            arrs.push(-(i*35)+'px');
            //alert(arrs);
            $(".left_menu_dl").eq(i).find(".left_menu_con.this").css("top",arrs[i]);
        }

        if(jQuery(".left_menu_dd[id=child_"+sc_id+"]").html()==null){
            jQuery.ajax({type:'POST',url:'http://b2b2c.iskyshop.com/nav_data.htm',data:{"sc_id":sc_id},success:function(data){
                    if(jQuery(".left_menu_dd[id=child_"+sc_id+"]").html()==null){
                        jQuery(".left_menu_dt[id=dts_"+sc_id+"]").after(data);
                    }
                    if(child_count>0){
                        jQuery("#dts_"+sc_id).addClass("left_menu_this").removeClass("left_menu_dt");
                        jQuery("#child_"+sc_id).show();
                    }
                    jQuery("#left_menu_con_"+sc_id).attr("style","border:1px solid "+sc_color+"; border-left:1px solid "+sc_color+";").find(".menu_con_right_top").css("background-color",sc_color);
                    var z = -35;
                    var x = eq*z;
                    jQuery("#left_menu_con_"+sc_id).css('margin-top',x+'px');
                    jQuery(".left_menu_dd[id=child_"+sc_id+"]").show();
                }});
        }else{
            if(child_count>0){
                jQuery("#dts_"+sc_id).addClass("left_menu_this").removeClass("left_menu_dt");
                jQuery("#child_"+sc_id).show();
            }
            jQuery("#left_menu_con_"+sc_id).attr("style","border:1px solid "+sc_color+"; border-left:1px solid "+sc_color+";").find(".menu_con_right_top").css("background-color",sc_color);
            var z = -35;
            var x = eq*z;
            jQuery("#left_menu_con_"+sc_id).css('margin-top',x+'px');
            jQuery(".left_menu_dd[id=child_"+sc_id+"]").show();
        }

    }).mouseleave(function(e){
        jQuery("dt[id^=dts_]").removeAttr("style");
        jQuery("div[id^=left_menu_con_]").removeAttr("style");
        var child_count = jQuery(this).attr("child_count");
        jQuery("dt[id^=dts_]").removeClass("left_menu_this").addClass("left_menu_dt");
        jQuery(".left_menu_dd[id^=child_]").hide();
    });
    jQuery(".nav_left").mouseover(function(){
        jQuery("#other_menu").show();

    });
    jQuery(".nav_left").mouseleave(function(){
        jQuery("#other_menu").hide();
    });
});
