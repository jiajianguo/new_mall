package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.IFavoriteService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.ShoppingFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class FavoriteBuyerController {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IFavoriteService favoriteService;

    @Autowired
    private GoodsViewTools goodsViewTools;

    @SecurityMapping(display = false, rsequence = 0, title="用户商品收藏", value="/buyer/favorite_*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/favorite_goods.htm"})
    public ModelAndView favorite_goods(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView(
                "/buyer/favorite_goods.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))) {
            url = CommUtil.getURL(request);
        }
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        String params = "";
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy",orderBy);
        map.put("sort",orderType);
        map.put("type",Integer.valueOf(0));
        map.put("user_id",SecurityUserHolder.getCurrentUser().getId());
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List<ShoppingFavorite> pList = favoriteService.queryByCondition(map);
        goodsViewTools.addFavoriteGoods(pList);

        if(pList != null && pList.size() >0){
            int count =  this.favoriteService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView(url + "/buyer/favorite_", "", params, page, mv);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="用户店铺收藏", value="/buyer/favorite_store.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/favorite_store.htm"})
    public ModelAndView favorite_store(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView("/buyer/favorite_store.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))) {
            url = CommUtil.getURL(request);
        }
        String params = "";
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy",orderBy);
        map.put("sort",orderType);
        map.put("type",Integer.valueOf(1));
        map.put("user_id",SecurityUserHolder.getCurrentUser().getId());
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List<ShoppingFavorite> pList = favoriteService.queryByCondition(map);
        goodsViewTools.addFavoriteGoods(pList);
        if(pList != null && pList.size() >0){
            int count =  this.favoriteService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView(url + "/buyer/favorite_store.htm", "", params, page, mv);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="用户收藏删除", value="/buyer/favorite_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/favorite_del.htm"})
    public void favorite_del(HttpServletRequest request, HttpServletResponse response, String mulitId, String currentPage, int type) throws IOException {
        String[] ids = mulitId.split(",");
        for (String id : ids) {
            if (!id.equals("")) {
                ShoppingFavorite favorite = this.favoriteService.getObjById(Long.valueOf(Long.parseLong(id)));
                this.favoriteService.delete(Long.valueOf(Long.parseLong(id)));
            }
        }
        if (type == 0) {
            response.sendRedirect("favorite_?currentPage=" + currentPage);
        }else{
            response.sendRedirect("favorite_store.htm?currentPage=" + currentPage);
        }
    }



}
