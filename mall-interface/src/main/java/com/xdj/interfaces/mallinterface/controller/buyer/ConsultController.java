package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.UserViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.IConsultService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.ShoppingConsultWithBLOBs;
import com.xdj.www.entity.ShoppingFavorite;
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
public class ConsultController {

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IConsultService consultService;

    @Autowired
    private UserViewTools userViewTools;

    @SecurityMapping(display = false, rsequence = 0, title="买家咨询列表", value="/buyer/consult.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/consult.htm"})
    public ModelAndView consult(HttpServletRequest request, HttpServletResponse response, String reply, String currentPage)
    {
        ModelAndView mv = new JModelAndView(
                "/buyer/buyer_consult.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("consult_user_id",SecurityUserHolder.getCurrentUser().getId());
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        if (!CommUtil.null2String(reply).equals("")) {
            map.put("reply",Boolean.valueOf(CommUtil.null2Boolean(reply)));

        }
        List<ShoppingConsultWithBLOBs> pList = consultService.queryByCondition(map);
        userViewTools.addConsultUsers(pList);

        if(pList != null && pList.size() >0){
            int count =  this.consultService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            if(count%10==0){
                page.setPages(count/10);
            }else{
                page.setPages(count/10 +1);
            }
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

        }

        mv.addObject("reply", CommUtil.null2String(reply));
        return mv;
    }




}
