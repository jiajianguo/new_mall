package com.xdj.www.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingGoodsWithBLOBs extends ShoppingGoods {
    private String goodsDetails;

    private String goodsInventoryDetail;

    private String goodsProperty;

    private String seoDescription;

    private String ztcAdminContent;

    /**
     *货物商店
     */
    private  ShoppingStoreWithBLOBs  goods_store;
    /**
     * 商品分类
     */
    private ShoppingGoodsclass shoppingGoodsclass;
    /**
     *主图
     */
    private ShoppingAccessory goods_main_photo;
    /**
     * 商品全部图片
     */
    private List<ShoppingAccessory> goods_photos;

    /**
     * 用户商品分类
     * @return
     */
    private List<ShoppingUsergoodsclass> goods_ugcs;

    /**
     * 商品属性
     */
    private List<ShoppingGoodsspecproperty> goods_specs;

    /**
     * 商品品牌
     * @return
     */
    private  ShoppingGoodsbrand goods_brand;

    /**
     * 商品分组
     */
    private List<ShoppingGroupGoods> group_goods_list = new ArrayList<ShoppingGroupGoods>();
    /**
     * 商品咨询
     */
    private List<ShoppingConsult> consults = new ArrayList<ShoppingConsult>();
    /**
     * 评价
     */
    private List<ShoppingEvaluateWithBLOBs> evaluates = new ArrayList<ShoppingEvaluateWithBLOBs>();
    /**
     * 受欢迎的
     */
    private List<ShoppingFavorite > favs = new ArrayList<ShoppingFavorite>();
    /**
     * 运输
     */
    private ShoppingTransportWithBLOBs transport;
    /**
     * 动态
     */
    private List<ShoppingDynamic> dynamics = new ArrayList<ShoppingDynamic>();
    /**
     * 议价商品
     */
    private List<ShoppingBargainGoods> bargainGoods_list = new ArrayList<ShoppingBargainGoods>();
    /**
     * 活动商品
     */
    private List<ShoppingActivityGoods> ag_goods_list = new ArrayList<ShoppingActivityGoods>();
    /**
     * 商品分组
     */
    private ShoppingGroup  group;

    private ShoppingDeliveryGoods dg;

    /**
     * 商品规格
     */
    private List<ShoppingGoodsspecification> specification ;
    /**
     * 商品规格
     */
    private List<ShoppingGoodsWithBLOBs> combin_goods ;

    @Override
    public String toString() {

        return "ShoppingGoodsWithBLOBs{" +
                "goodsDetails='" + goodsDetails + '\'' +
                ", goodsInventoryDetail='" + goodsInventoryDetail + '\'' +
                ", goodsProperty='" + goodsProperty + '\'' +
                ", seoDescription='" + seoDescription + '\'' +
                ", ztcAdminContent='" + ztcAdminContent + '\'' +
                ", goods_store=" + goods_store +
                ", shoppingGoodsclass=" + shoppingGoodsclass +
                ", goods_main_photo=" + goods_main_photo +
                ", goods_photos=" + goods_photos +
                ", goods_ugcs=" + goods_ugcs +
                ", goods_specs=" + goods_specs +
                ", goods_brand=" + goods_brand +
                ", group_goods_list=" + group_goods_list +
                ", consults=" + consults +
                ", evaluates=" + evaluates +
                ", favs=" + favs +
                ", transport=" + transport +
                ", dynamics=" + dynamics +
                ", bargainGoods_list=" + bargainGoods_list +
                ", ag_goods_list=" + ag_goods_list +
                ", combin_goods=" + combin_goods +
                '}';
    }


    public List<ShoppingGoodsspecification> getSpecification() {
        return specification;
    }

    public void setSpecification(List<ShoppingGoodsspecification> specification) {
        this.specification = specification;
    }

    public ShoppingDeliveryGoods getDg() {
        return dg;
    }

    public void setDg(ShoppingDeliveryGoods dg) {
        this.dg = dg;
    }

    public ShoppingGroup getGroup() {
        return group;
    }

    public void setGroup(ShoppingGroup group) {
        this.group = group;
    }

    public List<ShoppingGoodsWithBLOBs> getCombin_goods() {
        return combin_goods;
    }

    public void setCombin_goods(List<ShoppingGoodsWithBLOBs> combin_goods) {
        this.combin_goods = combin_goods;
    }

    public ShoppingStoreWithBLOBs getGoods_store() {
        return goods_store;
    }

    public void setGoods_store(ShoppingStoreWithBLOBs goods_store) {
        this.goods_store = goods_store;
    }

    public ShoppingGoodsclass getShoppingGoodsclass() {
        return shoppingGoodsclass;
    }

    public void setShoppingGoodsclass(ShoppingGoodsclass shoppingGoodsclass) {
        this.shoppingGoodsclass = shoppingGoodsclass;
    }

    public ShoppingAccessory getGoods_main_photo() {
        return goods_main_photo;
    }

    public void setGoods_main_photo(ShoppingAccessory goods_main_photo) {
        this.goods_main_photo = goods_main_photo;
    }

    public List<ShoppingAccessory> getGoods_photos() {
        return goods_photos;
    }

    public void setGoods_photos(List<ShoppingAccessory> goods_photos) {
        this.goods_photos = goods_photos;
    }

    public List<ShoppingUsergoodsclass> getGoods_ugcs() {
        return goods_ugcs;
    }

    public void setGoods_ugcs(List<ShoppingUsergoodsclass> goods_ugcs) {
        this.goods_ugcs = goods_ugcs;
    }

    public List<ShoppingGoodsspecproperty> getGoods_specs() {
        return goods_specs;
    }

    public void setGoods_specs(List<ShoppingGoodsspecproperty> goods_specs) {
        this.goods_specs = goods_specs;
    }

    public ShoppingGoodsbrand getGoods_brand() {
        return goods_brand;
    }

    public void setGoods_brand(ShoppingGoodsbrand goods_brand) {
        this.goods_brand = goods_brand;
    }

    public List<ShoppingGroupGoods> getGroup_goods_list() {
        return group_goods_list;
    }

    public void setGroup_goods_list(List<ShoppingGroupGoods> group_goods_list) {
        this.group_goods_list = group_goods_list;
    }

    public List<ShoppingConsult> getConsults() {
        return consults;
    }

    public void setConsults(List<ShoppingConsult> consults) {
        this.consults = consults;
    }

    public List<ShoppingEvaluateWithBLOBs> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List<ShoppingEvaluateWithBLOBs> evaluates) {
        this.evaluates = evaluates;
    }

    public List<ShoppingFavorite> getFavs() {
        return favs;
    }

    public void setFavs(List<ShoppingFavorite> favs) {
        this.favs = favs;
    }

    public ShoppingTransportWithBLOBs getTransport() {
        return transport;
    }

    public void setTransport(ShoppingTransportWithBLOBs transport) {
        this.transport = transport;
    }

    public List<ShoppingDynamic> getDynamics() {
        return dynamics;
    }

    public void setDynamics(List<ShoppingDynamic> dynamics) {
        this.dynamics = dynamics;
    }

    public List<ShoppingBargainGoods> getBargainGoods_list() {
        return bargainGoods_list;
    }

    public void setBargainGoods_list(List<ShoppingBargainGoods> bargainGoods_list) {
        this.bargainGoods_list = bargainGoods_list;
    }

    public List<ShoppingActivityGoods> getAg_goods_list() {
        return ag_goods_list;
    }

    public void setAg_goods_list(List<ShoppingActivityGoods> ag_goods_list) {
        this.ag_goods_list = ag_goods_list;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails == null ? null : goodsDetails.trim();
    }

    public String getGoodsInventoryDetail() {
        return goodsInventoryDetail;
    }

    public void setGoodsInventoryDetail(String goodsInventoryDetail) {
        this.goodsInventoryDetail = goodsInventoryDetail == null ? null : goodsInventoryDetail.trim();
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty == null ? null : goodsProperty.trim();
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getZtcAdminContent() {
        return ztcAdminContent;
    }

    public void setZtcAdminContent(String ztcAdminContent) {
        this.ztcAdminContent = ztcAdminContent == null ? null : ztcAdminContent.trim();
    }
}
