package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IAccessoryService;
import com.xdj.www.entity.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class AccessoryViewTools {
    @Resource
    private IAccessoryService accessoryService;

    public void addPosImg(ShoppingAdvPosWithBLOBs ap){
        if(ap != null && ap.getApAccId() != null){
            ap.setApAcc(accessoryService.getObjById(ap.getApAccId()));
        }

    }

    public void addAdvertImg(ShoppingAdvert advert){
        if(advert != null && advert.getAdAccId() != null){
            advert.setAdAcc(accessoryService.getObjById(advert.getAdAccId()));
        }
    }

    public void addLoginImgs(ShoppingSysconfigWithBLOBs config) {
        if(config != null){
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("config_id",config.getId());
            List<ShoppingAccessory> imgs = accessoryService.queryByCondition(params);
        }
    }

    /**
     *
     * @param list
     */
    public void logoPhotoHandle(List<ShoppingGoodsbrand> list){
        if(list != null){
            for(ShoppingGoodsbrand s: list){
                if(s.getBrandlogoId() != null){
                    ShoppingAccessory accessory = accessoryService.getObjById(s.getBrandlogoId());
                    s.setBrandLogo(accessory);
                }
            }
        }
    }

    public void addMainPhoto(ShoppingGoodsWithBLOBs goods){
        if(goods != null){
            if(goods.getGoodsMainPhotoId() != null){
                goods.setGoods_main_photo(accessoryService.getObjById(goods.getGoodsMainPhotoId()));
            }
        }
    }


    public void addMainPhotos(List<ShoppingGoodsWithBLOBs> goods){
        if(goods != null){
          for(ShoppingGoodsWithBLOBs g: goods){
              addMainPhoto(g);
          }
        }
    }

    public void addAccImg(ShoppingActivity act) {
        if(act != null && act.getAcAccId() != null){
            act.setAc_acc(accessoryService.getObjById(act.getAcAccId()));
        }
    }

    public void addSeckillPhoto(ShoppingSecondsKill s) {
        if(s !=  null){
            s.setSg_img(accessoryService.getObjById(s.getSgImgId()));
        }
    }
    public void addGroupImg(ShoppingGroupGoods groupGoods) {
        if(groupGoods != null && groupGoods.getGgImgId() != null){
            groupGoods.setGg_img(accessoryService.getObjById(groupGoods.getGgImgId()));
        }
    }

    public void addUserHeadImg(ShoppingUser user) {
        if(user != null){
            user.setPhoto(accessoryService.getObjById(user.getPhotoId()));
        }
    }

    public void addStoreLogo(ShoppingStoreWithBLOBs store) {
        if(store != null && store.getStoreLogoId() != null){
            store.setStoreLogo(accessoryService.getObjById(store.getStoreLogoId()));
        }
    }

    public void addIntegralGoodsImg(ShoppingIntegralGoods goods) {
        if(goods != null && goods.getIgGoodsImgId() !=null){
            goods.setIgGoodsImg(accessoryService.getObjById(goods.getIgGoodsImgId()));
        }
    }

    public void addStoreLogos(List<ShoppingStoreWithBLOBs> pList) {
        if(pList  != null){
            for(ShoppingStoreWithBLOBs s: pList){
                addStoreLogo(s);
            }
        }
    }


    public void addGoodsPhotos(ShoppingGoodsWithBLOBs goods) {
        if(goods != null){
            goods.setGoods_photos(accessoryService.queryByGoodsId(goods.getId()));
        }
    }

    public void addUserHeadImgs(List<ShoppingUser> pList) {
        if(pList != null){
            for(ShoppingUser s: pList){
                addUserHeadImg(s);
            }
        }
    }

    public void addUserGcImgs(ShoppingUsergoodsclass gc) {
        if(gc != null && gc.getStoreGcimgId() != null){
            gc.setStore_gc_img(accessoryService.getObjById(gc.getStoreGcimgId()));
        }
    }

    public void addStoreSliderImg(ShoppingStoreSlide s) {
        if(s != null && s.getAccId() != null){
            s.setSliderImg(accessoryService.getObjById(s.getAccId()));
        }
    }

    public void addAdvertsImg(List<ShoppingAdvert> advs) {
        if(advs != null ){
            for(ShoppingAdvert s: advs){
                addAdvertImg(s);
            }
        }

    }
}
