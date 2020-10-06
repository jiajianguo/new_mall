function cart_remove(id,store_id){
    jQuery.post('/remove_goods_cart.htm',{"id":id,"store_id":store_id},function(data){
        jQuery("div[class=table] tr[id="+id+"]").remove();
        jQuery(".shopping[id="+id+"]").remove();
        jQuery(".shopp_ingtop[id="+id+"]").remove();
        jQuery("#cart_goods_count_top").html(data.count);
        jQuery("#cart_goods_price_top").html(data.total_price);
        jQuery("#top_total_price_"+store_id).html(data.total_price);
        if(store_id!=""){
            jQuery("#total_price_"+store_id).html(data.sc_total_price);
        }
        if( jQuery("form[id=cart_"+store_id+"]").find("tr[goods_list^=goods_info]").length==0){
            jQuery("form[id=cart_"+store_id+"]").remove();
        }
        if(jQuery("tr[goods_list^=goods_info]").length==0){
            jQuery(".car_nogoods").show();
        }
    },"json");
}
/*jQuery(document).ready(function(){
    jQuery("#cart_goods_top_menu").mouseover(function(){
        jQuery.ajax({type:'POST',url:'/cart_menu_detail.htm',data:'',
            beforeSend:function(){
                jQuery("#cart_goods_top_info").empty().html('<div class="menu-bd-panel"><div style="text-align:center;"><img src="/style/common/images/loader.gif" /></div></div>');
                jQuery("#cart_goods_top_info").show();
            },
            success:function(data){
                jQuery("#cart_goods_top_info").empty();
                jQuery("#cart_goods_top_info").html(data);
            }
        });
    });
    jQuery("#cart_menu").mouseleave(function(){
        jQuery("#cart_goods_top_info").hide();
    });
});*/
