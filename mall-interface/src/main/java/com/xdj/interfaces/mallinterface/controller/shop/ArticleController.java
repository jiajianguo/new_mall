package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.ArticleClassViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ArticleViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.service.IArticleClassService;
import com.xdj.interfaces.mallinterface.service.IArticleService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.ShoppingArticle;
import com.xdj.www.entity.ShoppingArticleclass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    private ISysConfigService configService;
    @Autowired
    private IUserConfigService userConfigService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IArticleClassService articleClassService;
    @Autowired
    private ArticleViewTools articleTools;
    @Autowired
    private ViewTools viewTools;
    @Autowired
    private ArticleClassViewTools articleClassViewTools;


    @RequestMapping({"/articlelist.htm"})
    public ModelAndView articlelist(HttpServletRequest request, HttpServletResponse response, String param, String currentPage){
        ModelAndView mv = new JModelAndView("articlelist.html", this.configService
                .getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        ShoppingArticleclass ac = null;
        Map<String,Object> params =new HashMap<>();
        //aqo.setCurrentPage(Integer.valueOf(CommUtil.null2Int(currentPage)));
        Long id = CommUtil.null2Long(param);
        String mark = "";
        if (id.longValue() == -1L) {
            mark = param;
        }
        if (!"".equals(mark)) {
            params.put("mark",mark);
            ac = this.articleClassService.queryByMap(params);

        }
        params.clear();
        params.put("articleClass_id",ac.getId());
        if (id.longValue() != -1L) {
            params.put("articleClass_id",id);
            ac = this.articleClassService.getObjById(id);
        }
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        params.put("display",Boolean.valueOf(true));
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("start",(pageNow-1)*15);
        params.put("pageSize",15);
        List<ShoppingArticle> pList = this.articleService.queryByCondition(params);
        String url = CommUtil.getURL(request) + "/articlelist.htm?currentPage=1&param=" + ac.getId();
        if(pList != null){
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = this.articleService.count(params);
            page.setRowCount(count);
            page.setCurrentPage(pageNow);
            page.setPages(count/15);
           com.xdj.interfaces.mallinterface.util.CommUtil.saveIPageList2ModelAndView("", url, "", page, mv);
        }
        List<ShoppingArticleclass> acs = this.articleClassService.queryByCondition(params);
        //"select obj from ArticleClass obj where obj.parent.id is null order by obj.sequence asc",null, -1, -1);
        params.clear();
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("start",0);
        params.put("pageSize",6);
        List<ShoppingArticle> articles = this.articleService.queryByCondition(params);
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        mv.addObject("ac", ac);
        mv.addObject("articles", articles);
        mv.addObject("acs", acs);
        return mv;
    }


    @RequestMapping({"/article.htm"})
    public ModelAndView article(HttpServletRequest request, HttpServletResponse response, String param) {
        ModelAndView mv = new JModelAndView("article.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingArticle obj = null;
        Map<String, Object> params = new HashMap<>();
        Long id = CommUtil.null2Long(param);
        String mark = "";
        if (id.longValue() == -1L) {
            mark = param;
        }
        if (id.longValue() != -1L) {
            obj = this.articleService.getObjById(id);
        }
        if (!("").equals(mark)) {
            params.put("mark", mark);
            obj = this.articleService.queryByMap(params);
        }
        params.clear();
        params.put("parent_id", "is  null");
        params.put("orderBy", "sequence");
        params.put("sort", "asc");
        List<ShoppingArticleclass> acs = this.articleClassService.queryByCondition(params);
        params.clear();
        params.put("orderBy", "addTime");
        params.put("sort", "desc");
        params.put("start", 0);
        params.put("pageSize", 6);
        List<ShoppingArticle> articles = this.articleService.queryByCondition(params);
        if (obj != null) {
            articleClassViewTools.addArticleClass(obj);
            mv.addObject("previousArticle", articleTools.queryArticle(obj.getId(), -1));
            mv.addObject("nextArticle", articleTools.queryArticle(obj.getId(), 1));
        }
        mv.addObject("articles", articles);
        mv.addObject("acs", acs);
        mv.addObject("obj", obj);
        viewTools.topHandle(mv, request);
        viewTools.headHandle(mv, request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        return mv;

    }
}
