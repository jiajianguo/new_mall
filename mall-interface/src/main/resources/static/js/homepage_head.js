//添加关注
jQuery(document).ready(function(){
    jQuery("#add_atten").click(function(){
        var user_id= jQuery(this).attr("user_id");
        jQuery.post("/buyer/homepage_add_attention.htm",
            {
                "user_id":user_id
            },
            function(data){
                if(data=="true"){
                    showDialog("share_sns","系统提示","关注成功！",0,"succeed",3);
                }else{
                    showDialog("share_sns","系统提示","您已经关注过该用户！",0,"error",3);
                }
            },"text");
    });

    //点击发布按钮
    jQuery("#fabu").click(function(){
        jQuery("#share_select_mark").val("");
        showDialog("share_sns","我要发布","",2,"succeed",3,select_method);
    });

});
//个人主页选择分享方式，三种分享方式，分享宝贝，分享店铺，分享新鲜事
function select_method(){
    var mark = jQuery("#share_select_mark").val();
    if(mark==3){
        jQuery("#over").show();
        jQuery(".black_overlay").css("height",jQuery(document).height());
        query_babys();
    }
    if(mark==4){
        jQuery("#over").show();
        jQuery(".black_overlay").css("height",jQuery(document).height());
        query_stores();
    }
    if(mark==5){
        showDialog("select_dynamic_mark_5","分享新鲜事","",5,"succeed","",select_dynamic_save);//第四个参数为5，弹出分享新鲜事窗口
    }
};
//个人主页分享保存方法
function select_dynamic_save(){
    var content =jQuery("#share_select_content").val();
    jQuery.post("/buyer/dynamic_save.htm",
        {
            "content":content
        },
        function(data){
            if(data){
                showDialog("share_sns","系统提示","发布成功！",0,"succeed",5);
            }
        },"text");
};
//查询已经购买的宝贝和已经收藏的宝贝
function query_babys(){
    jQuery.post("/buyer/homepage_query_goods.htm",
        function(data){
            if(data){
                jQuery("#over").hide();
                jQuery("body").append(data);
            }
        },"text");
};
function query_stores(){
    jQuery.post("/buyer/homepage_query_stores.htm",
        {
        },
        function(data){
            if(data){
                jQuery("#over").hide();
                jQuery("body").append(data);
            }
        },"text");
};