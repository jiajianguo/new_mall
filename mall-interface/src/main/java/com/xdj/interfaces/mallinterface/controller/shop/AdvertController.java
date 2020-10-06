package com.xdj.interfaces.mallinterface.controller.shop;

import com.alipay.api.domain.Advert;
import com.xdj.interfaces.mallinterface.controller.view.AccessoryViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.service.IAdvertPositionService;
import com.xdj.interfaces.mallinterface.service.IAdvertService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.ShoppingAdvPos;
import com.xdj.www.entity.ShoppingAdvPosWithBLOBs;
import com.xdj.www.entity.ShoppingAdvert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author Administrator
 */
@RestController
public class AdvertController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IAdvertPositionService advertPositionService;
    @Resource
    private IAdvertService advertService;
    @Resource
    private AccessoryViewTools accessoryViewTools;

    @RequestMapping({"/advert_invoke.htm"})
    public ModelAndView advert_invoke(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView("advert_invoke.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);

        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );

        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/advert_invoke.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        if ((id != null) && (!id.equals(""))) {
            ShoppingAdvPos ap = this.advertPositionService.getObjById(CommUtil.null2Long(id));
            if (ap != null) {
                ap.getAdvId();
                Map<String,Object> para = new HashMap<String,Object>();
                para.put("ad_ap_id",ap.getId());
                para.put("startTime",new Date());
                para.put("endTime",new Date());
                List<ShoppingAdvert> advs = advertService.queryByCondition(para);
                accessoryViewTools.addAdvertsImg(advs);
                if (advs != null && advs.size() > 0) {
                    if (ap.getApType().equals("text")) {
                        if (ap.getApShowType() == 0) {
                            ap.setApText(advs.get(0).getAdText());
                            ap.setApAccUrl(advs.get(0).getAdUrl());
                            ap.setAdvId(advs.get(0).getId());
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            int i = random.nextInt(advs.size());
                            ap.setApText(advs.get(i).getAdText());
                            ap.setApAccUrl(advs.get(i).getAdUrl());
                            ap.setAdvId(advs.get(i).getId());
                        }
                    }
                    if (ap.getApType().equals("img")) {
                        if (ap.getApShowType() == 0) {
                            ap.setApAcc(advs.get(0).getAdAcc());
                            ap.setApAccUrl(advs.get(0).getAdUrl());
                            ap.setAdvId(advs.get(0).getId());
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            int i = random.nextInt(advs.size());
                            ap.setApAcc(advs.get(i).getAdAcc());
                            ap.setApAccUrl(advs.get(i).getAdUrl());
                            ap.setAdvId(advs.get(i).getId());
                        }
                    }
                    Iterator localIterator2;
                    if (ap.getApType().equals("slide")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                ap.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                    if (ap.getApType().equals("wapslide")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        List<ShoppingAdvert> ads = new ArrayList<>();
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                ads.add(advs.get(i));
                                ap.setAdvs(ads);
                            }
                        }
                    }
                    if (ap.getApType().equals("indexslide")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        List<ShoppingAdvert> ads = new ArrayList<>();
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                ads.add(advs.get(i));
                                ap.setAdvs(ads);
                            }
                        }
                    }
                    if (ap.getApType().equals("scroll")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 12);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                ap.getAdvs().add(advs.get(i)); }
                        }
                    }
                }
                else {
                    ShoppingAdvert adv = new ShoppingAdvert();
                    adv.setAdUrl(ap.getApAccUrl());
                    adv.setAdAcc(ap.getApAcc());
                    ap.getAdvs().add(adv);
                }
                if (ap.getApStatus() == 1) {
                    mv.addObject("obj", ap);
                }else {
                    mv.addObject("obj", new ShoppingAdvPos());
                }
            }
        }
        return mv;
    }


   /* @RequestMapping({"/advert_invoke.htm"})
    public ModelAndView advert_invoke(HttpServletRequest request, HttpServletResponse response, String id)
    {
        ModelAndView mv = new JModelAndView("advert_invoke.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/advert_invoke.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }

        if ((id != null) && (!id.equals(""))) {
            ShoppingAdvPosWithBLOBs ap = this.advertPositionService.getObjById(CommUtil.null2Long(id));
            if (ap != null) {
                ShoppingAdvPosWithBLOBs obj = new ShoppingAdvPosWithBLOBs();
                obj.setApType(ap.getApType());
                obj.setApStatus(ap.getApStatus());
                obj.setApShowType(ap.getApShowType());
                obj.setApWidth(ap.getApWidth());
                obj.setApHeight(ap.getApHeight());
                Map<String,Object> para = new HashMap<String,Object>();
                para.put("ad_ap_id",ap.getId());
                para.put("startTime",new Date());
                para.put("endTime",new Date());
                List<ShoppingAdvert> advs = advertService.queryByCondition(para);
                if (advs.size() > 0) {
                    accessoryViewTools.addAdvertsImg(advs);
                    if (obj.getApType().equals("text")) {
                        if (obj.getApShowType() == 0) {
                            ShoppingAdvert advert=advs.get(0);
                            obj.setApText(advert.getAdText());
                            obj.setApAccUrl(advert.getAdUrl());
                            obj.setAdvId(advert.getId());
                        }
                        if (obj.getApShowType() == 1) {
                            Random random = new Random();
                            int i = random.nextInt(advs.size());
                            obj.setApText((advs.get(i)).getAdText());
                            obj.setApAccUrl((advs.get(i)).getAdUrl());
                            obj.setAdvId((advs.get(i)).getId());
                        }
                    }
                    if (obj.getApType().equals("img")) {
                        if (obj.getApShowType() == 0) {
                            obj.setApAcc((advs.get(0)).getAdAcc());
                            obj.setApAccUrl((advs.get(0)).getAdUrl());
                            obj.setAdvId((advs.get(0)).getId());
                        }
                        if (obj.getApShowType() == 1) {
                            Random random = new Random();
                            int i = random.nextInt(advs.size());
                            obj.setApAcc((advs.get(i)).getAdAcc());
                            obj.setApAccUrl((advs.get(i)).getAdUrl());
                            obj.setAdvId((advs.get(i)).getId());
                        }
                    }
                    Iterator localIterator2;
                    if (obj.getApType().equals("slide")) {
                        if (obj.getApShowType() == 0) {
                            obj.setAdvs(advs);
                        }
                        if (obj.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                obj.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                    if (obj.getApType().equals("wapslide")) {
                        if (obj.getApShowType() == 0) {
                            obj.setAdvs(advs);
                        }
                        List<ShoppingAdvert> ads = new ArrayList<>();
                        if (obj.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                ads.add(advs.get(i));
                                obj.setAdvs(ads);
                            }
                        }
                    }
                    if (obj.getApType().equals("indexslide")) {
                        if (obj.getApShowType() == 0) {
                            obj.setAdvs(advs);
                        }
                        if (obj.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                obj.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                    if (obj.getApType().equals("scroll")) {
                        if (obj.getApShowType() == 0) {
                            obj.setAdvs(advs);
                        }
                        if (obj.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 12);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer)localIterator2.next()).intValue();
                                obj.getAdvs().add(advs.get(i)); }
                        }
                    }
                }
                else {
                    obj.setApAcc(ap.getApAcc());
                    obj.setApText(ap.getApText());
                    obj.setApAccUrl(ap.getApAccUrl());
                    ShoppingAdvert adv = new ShoppingAdvert();
                    adv.setAdUrl(obj.getApAccUrl());
                    adv.setAdAcc(ap.getApAcc());
                    obj.getAdvs().add(adv);
                }
                if (obj.getApStatus() == 1) {
                    mv.addObject("obj", obj);
                }
                else {
                    mv.addObject("obj", new ShoppingAdvPosWithBLOBs());
                }
            }
        }
        return mv;
    }
*/
    @RequestMapping({"/advert_redirect.htm"})
    public void advert_redirect(HttpServletRequest request, HttpServletResponse response, String id){
        try{
            ShoppingAdvert adv = this.advertService.getObjById(CommUtil.null2Long(id));
            if (adv != null) {
                adv.setAdClickNum(adv.getAdClickNum() + 1);
                this.advertService.update(adv);
            }
            if (adv != null) {
                String url = adv.getAdUrl();
                response.sendRedirect(url);
            } else {
                response.sendRedirect(CommUtil.getURL(request));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
