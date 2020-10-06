package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.AreaViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.IAddressService;
import com.xdj.interfaces.mallinterface.service.IAreaService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.interfaces.mallinterface.util.database.DatabaseTools;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.ShoppingAddress;
import com.xdj.www.entity.ShoppingAddressExample;
import com.xdj.www.entity.ShoppingArea;
import com.xdj.www.entity.ShoppingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class AdressController {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IAreaService areaService;

    @Autowired
    private AreaViewTools areaViewTools;

    @Autowired
    private DatabaseTools databaseTools;

    @SecurityMapping(display = false, rsequence = 0, title="收货地址列表", value="/buyer/address.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/address.htm"})
    public ModelAndView address(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView("buyer/address.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/address.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))) {
            url = CommUtil.getURL(request);
        }
        String params = "";
        int pageNow=1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> param=new HashMap<>();
        param.put("orderBy",orderBy);
        param.put("sort",orderType);
        param.put("user_id",SecurityUserHolder.getCurrentUser().getId());
        param.put("start",(pageNow-1)*10);
        param.put("pageSize",10);
        List<ShoppingAddress> pList = addressService.queryByCondition(param);
        areaViewTools.addAdressAreas(pList);
        if(pList != null && pList.size() >0){
            int count =  this.addressService.count(param);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            //CommUtil.saveIPageList2ModelAndView(url + "/buyer/address.htm", "", params, page, mv);
            CommUtil.saveIPageList2ModelAndView( "", "", params, page, mv);
        }
        param.clear();
        param.put("parent_id","is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(param);
        mv.addObject("areas", areas);
        return mv;
    }


    /**
     * 新增收货地址页面
     * @param request
     * @param response
     * @param currentPage
     * @return
     */
    @SecurityMapping(display = false, rsequence = 0, title="新增收货地址", value="/buyer/address_add.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/address_add.htm"})
    public ModelAndView address_add(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView("buyer/address_add.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/address_add.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        Map<String,Object> params=new HashMap<>();
        params.put("parent_id","is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        areaViewTools.addManyChilds(areas,true);
        mv.addObject("areas", areas);
        mv.addObject("currentPage", currentPage);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="新增收货地址", value="/buyer/address_edit.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/address_edit.htm"})
    public ModelAndView address_edit(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) {
        ModelAndView mv = new JModelAndView("buyer/address_add.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/address_add.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        Map<String,Object> params=new HashMap<>();
        params.put("parent_id","is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        ShoppingAddress obj = this.addressService.getObjById(CommUtil.null2Long(id));
        areaViewTools.addAdressArea(obj);
        mv.addObject("obj", obj);
        mv.addObject("areas", areas);
        mv.addObject("currentPage", currentPage);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="收货地址保存", value="/buyer/address_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/address_save.htm"})
    public void address_save(HttpServletRequest request, HttpServletResponse response, String id, String area_id,String isdefault, String currentPage) throws IOException {
        ShoppingUser user=SecurityUserHolder.getCurrentUser();
        ShoppingAddress address = null;
        if (id == null || "".equals(id)) {
            address = new ShoppingAddress();
            address.setAddtime(new Date());
            address.setDeletestatus(false);
            address.setIsdefault(false);
            address.setTruename(request.getParameter("trueName"));
            address.setAreaInfo(request.getParameter("area_info"));
            address.setZip(request.getParameter("zip"));
            address.setMobile(request.getParameter("mobile"));
            address.setTelephone(request.getParameter("telephone"));
            address.setCity(request.getParameter("city"));
            address.setCompany(request.getParameter("company"));
            address.setCountries(request.getParameter("countries"));
            address.setUserId(user.getId());
            address.setDeletestatus(false);
        } else {
         address = this.addressService.getObjById(Long.valueOf(Long.parseLong(id)));
        }
        if(StringUtils.isBlank(isdefault)){
            if(isdefault.equals("1")){
                address.setIsdefault(true);
            }else{
                address.setIsdefault(false);
            }
        }

        if (id == null || "".equals(id)) {
            this.addressService.save(address);
        }else{
            ShoppingAddress addr = new ShoppingAddress();
            addr.setUserId(user.getId());
            addr.setIsdefault(false);
            this.addressService.updateByPrimaryKeySelective(addr);
            this.addressService.update(address);
        }
        response.sendRedirect("address.htm?currentPage=" + currentPage);

    }

    @SecurityMapping(display = false, rsequence = 0, title="收货地址删除", value="/buyer/address_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/address_del.htm"})
    public void address_del(HttpServletRequest request, HttpServletResponse response, String mulitId, String currentPage) throws IOException {
        String[] ids = mulitId.split(",");
        for (String id : ids) {
            if (!id.equals("")) {
                ShoppingAddress address = this.addressService.getObjById(
                        Long.valueOf(Long.parseLong(id)));
                this.addressService.delete(Long.valueOf(Long.parseLong(id)));
            }
        }
        response.sendRedirect("address.htm?currentPage=" + currentPage);
    }
}
