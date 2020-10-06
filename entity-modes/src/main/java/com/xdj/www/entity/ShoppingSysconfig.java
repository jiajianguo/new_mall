package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingSysconfig extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String address;

    private Integer bigheight;

    private Integer bigwidth;

    private Integer complaintTime;

    private String closeReason;

    private String codeStat;

    private Integer consumptionratio;

    private String copyright;

    private Boolean deposit;

    private String description;

    private Boolean emailenable;

    private String emailhost;

    private Integer emailport;

    private String emailpws;

    private String emailtest;

    private String emailuser;

    private String emailusername;

    private Integer everyindentlimit;

    private Boolean gold;

    private Integer goldmarketvalue;

    private Boolean groupbuy;

    private String hotsearch;

    private Integer imagefilesize;

    private String imagesavetype;

    private String imagesuffix;

    private Integer indentcomment;

    private Boolean integral;

    private Integer integralrate;

    private Boolean integralstore;

    private String keywords;

    private Integer memberdaylogin;

    private Integer memberregister;

    private Integer middleheight;

    private Integer middlewidth;

    private Boolean securitycodeconsult;

    private Boolean securitycodelogin;

    private Boolean securitycoderegister;

    private String securitycodetype;

    private Integer smallheight;

    private Integer smallwidth;

    private Boolean smsenbale;

    private String smspassword;

    private String smstest;

    private String smsurl;

    private String smsusername;

    private Boolean storeAllow;

    private String syslanguage;

    private String title;

    private String uploadfilepath;

    private Boolean visitorconsult;

    private Boolean voucher;

    private String websitename;

    private Boolean websitestate;

    private Integer ztcPrice;

    private Boolean ztcStatus;

    private Long goodsimageId;

    private Long membericonId;

    private Long storeimageId;

    private Long websitelogoId;

    private Integer domainAllowCount;

    private Boolean secondDomainOpen;

    private Boolean qqLogin;

    private String qqLoginId;

    private String qqLoginKey;

    private Boolean sinaLogin;

    private String sinaLoginId;

    private String sinaLoginKey;

    private String imagewebserver;

    private Date luceneUpdate;

    private Integer alipayFenrun;

    private Integer balanceFenrun;

    private Integer autoOrderConfirm;

    private Integer autoOrderNotice;

    private Integer bargainMaximum;

    private BigDecimal bargainRebate;

    private Integer bargainStatus;

    private String bargainTitle;

    private Integer sysDeliveryMaximum;

    private Boolean ucBbs;

    private String ucApi;

    private String ucAppid;

    private String ucDatabase;

    private String ucDatabasePort;

    private String ucDatabasePws;

    private String ucDatabaseUrl;

    private String ucDatabaseUsername;

    private String ucIp;

    private String ucKey;

    private String ucTablePreffix;

    private String currencyCode;

    private Integer bargainValidity;

    private Integer deliveryAmount;

    private Integer deliveryStatus;

    private String deliveryTitle;

    private String websitecss;

    private Integer combinAmount;

    private Integer combinCount;

    private Integer ztcGoodsView;

    private Integer autoOrderEvaluate;

    private Integer autoOrderReturn;

    private Boolean weixinStore;

    private Integer weixinAmount;

    private Integer configPaymentType;

    private String weixinAccount;

    private String weixinAppid;

    private String weixinAppsecret;

    private String weixinToken;

    private Long storeWeixinLogoId;

    private Long weixinQrImgId;

    private String siteUrl;

    private ShoppingAccessory goodsImage;

    public void setGoodsImage(ShoppingAccessory goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getCodeStat() {
        return codeStat;
    }

    public void setCodeStat(String codeStat) {
        this.codeStat = codeStat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getBigheight() {
        return bigheight;
    }

    public void setBigheight(Integer bigheight) {
        this.bigheight = bigheight;
    }

    public Integer getBigwidth() {
        return bigwidth;
    }

    public void setBigwidth(Integer bigwidth) {
        this.bigwidth = bigwidth;
    }

    public Integer getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(Integer complaintTime) {
        this.complaintTime = complaintTime;
    }

    public Integer getConsumptionratio() {
        return consumptionratio;
    }

    public void setConsumptionratio(Integer consumptionratio) {
        this.consumptionratio = consumptionratio;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public Boolean getDeposit() {
        return deposit;
    }

    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getEmailenable() {
        return emailenable;
    }

    public void setEmailenable(Boolean emailenable) {
        this.emailenable = emailenable;
    }

    public String getEmailhost() {
        return emailhost;
    }

    public void setEmailhost(String emailhost) {
        this.emailhost = emailhost == null ? null : emailhost.trim();
    }

    public Integer getEmailport() {
        return emailport;
    }

    public void setEmailport(Integer emailport) {
        this.emailport = emailport;
    }

    public String getEmailpws() {
        return emailpws;
    }

    public void setEmailpws(String emailpws) {
        this.emailpws = emailpws == null ? null : emailpws.trim();
    }

    public String getEmailtest() {
        return emailtest;
    }

    public void setEmailtest(String emailtest) {
        this.emailtest = emailtest == null ? null : emailtest.trim();
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser == null ? null : emailuser.trim();
    }

    public String getEmailusername() {
        return emailusername;
    }

    public void setEmailusername(String emailusername) {
        this.emailusername = emailusername == null ? null : emailusername.trim();
    }

    public Integer getEveryindentlimit() {
        return everyindentlimit;
    }

    public void setEveryindentlimit(Integer everyindentlimit) {
        this.everyindentlimit = everyindentlimit;
    }

    public Boolean getGold() {
        return gold;
    }

    public void setGold(Boolean gold) {
        this.gold = gold;
    }

    public Integer getGoldmarketvalue() {
        return goldmarketvalue;
    }

    public void setGoldmarketvalue(Integer goldmarketvalue) {
        this.goldmarketvalue = goldmarketvalue;
    }

    public Boolean getGroupbuy() {
        return groupbuy;
    }

    public void setGroupbuy(Boolean groupbuy) {
        this.groupbuy = groupbuy;
    }

    public String getHotsearch() {
        return hotsearch;
    }

    public void setHotsearch(String hotsearch) {
        this.hotsearch = hotsearch == null ? null : hotsearch.trim();
    }

    public Integer getImagefilesize() {
        return imagefilesize;
    }

    public void setImagefilesize(Integer imagefilesize) {
        this.imagefilesize = imagefilesize;
    }

    public String getImagesavetype() {
        return imagesavetype;
    }

    public void setImagesavetype(String imagesavetype) {
        this.imagesavetype = imagesavetype == null ? null : imagesavetype.trim();
    }

    public String getImagesuffix() {
        return imagesuffix;
    }

    public void setImagesuffix(String imagesuffix) {
        this.imagesuffix = imagesuffix == null ? null : imagesuffix.trim();
    }

    public Integer getIndentcomment() {
        return indentcomment;
    }

    public void setIndentcomment(Integer indentcomment) {
        this.indentcomment = indentcomment;
    }

    public Boolean getIntegral() {
        return integral;
    }

    public void setIntegral(Boolean integral) {
        this.integral = integral;
    }

    public Integer getIntegralrate() {
        return integralrate;
    }

    public void setIntegralrate(Integer integralrate) {
        this.integralrate = integralrate;
    }

    public Boolean getIntegralstore() {
        return integralstore;
    }

    public void setIntegralstore(Boolean integralstore) {
        this.integralstore = integralstore;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public Integer getMemberdaylogin() {
        return memberdaylogin;
    }

    public void setMemberdaylogin(Integer memberdaylogin) {
        this.memberdaylogin = memberdaylogin;
    }

    public Integer getMemberregister() {
        return memberregister;
    }

    public void setMemberregister(Integer memberregister) {
        this.memberregister = memberregister;
    }

    public Integer getMiddleheight() {
        return middleheight;
    }

    public void setMiddleheight(Integer middleheight) {
        this.middleheight = middleheight;
    }

    public Integer getMiddlewidth() {
        return middlewidth;
    }

    public void setMiddlewidth(Integer middlewidth) {
        this.middlewidth = middlewidth;
    }

    public Boolean getSecuritycodeconsult() {
        return securitycodeconsult;
    }

    public void setSecuritycodeconsult(Boolean securitycodeconsult) {
        this.securitycodeconsult = securitycodeconsult;
    }

    public Boolean getSecuritycodelogin() {
        return securitycodelogin;
    }

    public void setSecuritycodelogin(Boolean securitycodelogin) {
        this.securitycodelogin = securitycodelogin;
    }

    public Boolean getSecuritycoderegister() {
        return securitycoderegister;
    }

    public void setSecuritycoderegister(Boolean securitycoderegister) {
        this.securitycoderegister = securitycoderegister;
    }

    public String getSecuritycodetype() {
        return securitycodetype;
    }

    public void setSecuritycodetype(String securitycodetype) {
        this.securitycodetype = securitycodetype == null ? null : securitycodetype.trim();
    }

    public Integer getSmallheight() {
        return smallheight;
    }

    public void setSmallheight(Integer smallheight) {
        this.smallheight = smallheight;
    }

    public Integer getSmallwidth() {
        return smallwidth;
    }

    public void setSmallwidth(Integer smallwidth) {
        this.smallwidth = smallwidth;
    }

    public Boolean getSmsenbale() {
        return smsenbale;
    }

    public void setSmsenbale(Boolean smsenbale) {
        this.smsenbale = smsenbale;
    }

    public String getSmspassword() {
        return smspassword;
    }

    public void setSmspassword(String smspassword) {
        this.smspassword = smspassword == null ? null : smspassword.trim();
    }

    public String getSmstest() {
        return smstest;
    }

    public void setSmstest(String smstest) {
        this.smstest = smstest == null ? null : smstest.trim();
    }

    public String getSmsurl() {
        return smsurl;
    }

    public void setSmsurl(String smsurl) {
        this.smsurl = smsurl == null ? null : smsurl.trim();
    }

    public String getSmsusername() {
        return smsusername;
    }

    public void setSmsusername(String smsusername) {
        this.smsusername = smsusername == null ? null : smsusername.trim();
    }

    public Boolean getStoreAllow() {
        return storeAllow;
    }

    public void setStoreAllow(Boolean storeAllow) {
        this.storeAllow = storeAllow;
    }

    public String getSyslanguage() {
        return syslanguage;
    }

    public void setSyslanguage(String syslanguage) {
        this.syslanguage = syslanguage == null ? null : syslanguage.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUploadfilepath() {
        return uploadfilepath;
    }

    public void setUploadfilepath(String uploadfilepath) {
        this.uploadfilepath = uploadfilepath == null ? null : uploadfilepath.trim();
    }

    public Boolean getVisitorconsult() {
        return visitorconsult;
    }

    public void setVisitorconsult(Boolean visitorconsult) {
        this.visitorconsult = visitorconsult;
    }

    public Boolean getVoucher() {
        return voucher;
    }

    public void setVoucher(Boolean voucher) {
        this.voucher = voucher;
    }

    public String getWebsitename() {
        return websitename;
    }

    public void setWebsitename(String websitename) {
        this.websitename = websitename == null ? null : websitename.trim();
    }

    public Boolean getWebsitestate() {
        return websitestate;
    }

    public void setWebsitestate(Boolean websitestate) {
        this.websitestate = websitestate;
    }

    public Integer getZtcPrice() {
        return ztcPrice;
    }

    public void setZtcPrice(Integer ztcPrice) {
        this.ztcPrice = ztcPrice;
    }

    public Boolean getZtcStatus() {
        return ztcStatus;
    }

    public void setZtcStatus(Boolean ztcStatus) {
        this.ztcStatus = ztcStatus;
    }

    public Long getGoodsimageId() {
        return goodsimageId;
    }

    public void setGoodsimageId(Long goodsimageId) {
        this.goodsimageId = goodsimageId;
    }

    public Long getMembericonId() {
        return membericonId;
    }

    public void setMembericonId(Long membericonId) {
        this.membericonId = membericonId;
    }

    public Long getStoreimageId() {
        return storeimageId;
    }

    public void setStoreimageId(Long storeimageId) {
        this.storeimageId = storeimageId;
    }

    public Long getWebsitelogoId() {
        return websitelogoId;
    }

    public void setWebsitelogoId(Long websitelogoId) {
        this.websitelogoId = websitelogoId;
    }

    public Integer getDomainAllowCount() {
        return domainAllowCount;
    }

    public void setDomainAllowCount(Integer domainAllowCount) {
        this.domainAllowCount = domainAllowCount;
    }

    public Boolean getSecondDomainOpen() {
        return secondDomainOpen;
    }

    public void setSecondDomainOpen(Boolean secondDomainOpen) {
        this.secondDomainOpen = secondDomainOpen;
    }

    public Boolean getQqLogin() {
        return qqLogin;
    }

    public void setQqLogin(Boolean qqLogin) {
        this.qqLogin = qqLogin;
    }

    public String getQqLoginId() {
        return qqLoginId;
    }

    public void setQqLoginId(String qqLoginId) {
        this.qqLoginId = qqLoginId == null ? null : qqLoginId.trim();
    }

    public String getQqLoginKey() {
        return qqLoginKey;
    }

    public void setQqLoginKey(String qqLoginKey) {
        this.qqLoginKey = qqLoginKey == null ? null : qqLoginKey.trim();
    }

    public Boolean getSinaLogin() {
        return sinaLogin;
    }

    public void setSinaLogin(Boolean sinaLogin) {
        this.sinaLogin = sinaLogin;
    }

    public String getSinaLoginId() {
        return sinaLoginId;
    }

    public void setSinaLoginId(String sinaLoginId) {
        this.sinaLoginId = sinaLoginId == null ? null : sinaLoginId.trim();
    }

    public String getSinaLoginKey() {
        return sinaLoginKey;
    }

    public void setSinaLoginKey(String sinaLoginKey) {
        this.sinaLoginKey = sinaLoginKey == null ? null : sinaLoginKey.trim();
    }

    public String getImagewebserver() {
        return imagewebserver;
    }

    public void setImagewebserver(String imagewebserver) {
        this.imagewebserver = imagewebserver == null ? null : imagewebserver.trim();
    }

    public Date getLuceneUpdate() {
        return luceneUpdate;
    }

    public void setLuceneUpdate(Date luceneUpdate) {
        this.luceneUpdate = luceneUpdate;
    }

    public Integer getAlipayFenrun() {
        return alipayFenrun;
    }

    public void setAlipayFenrun(Integer alipayFenrun) {
        this.alipayFenrun = alipayFenrun;
    }

    public Integer getBalanceFenrun() {
        return balanceFenrun;
    }

    public void setBalanceFenrun(Integer balanceFenrun) {
        this.balanceFenrun = balanceFenrun;
    }

    public Integer getAutoOrderConfirm() {
        return autoOrderConfirm;
    }

    public void setAutoOrderConfirm(Integer autoOrderConfirm) {
        this.autoOrderConfirm = autoOrderConfirm;
    }

    public Integer getAutoOrderNotice() {
        return autoOrderNotice;
    }

    public void setAutoOrderNotice(Integer autoOrderNotice) {
        this.autoOrderNotice = autoOrderNotice;
    }

    public Integer getBargainMaximum() {
        return bargainMaximum;
    }

    public void setBargainMaximum(Integer bargainMaximum) {
        this.bargainMaximum = bargainMaximum;
    }

    public BigDecimal getBargainRebate() {
        return bargainRebate;
    }

    public void setBargainRebate(BigDecimal bargainRebate) {
        this.bargainRebate = bargainRebate;
    }

    public Integer getBargainStatus() {
        return bargainStatus;
    }

    public void setBargainStatus(Integer bargainStatus) {
        this.bargainStatus = bargainStatus;
    }

    public String getBargainTitle() {
        return bargainTitle;
    }

    public void setBargainTitle(String bargainTitle) {
        this.bargainTitle = bargainTitle == null ? null : bargainTitle.trim();
    }

    public Integer getSysDeliveryMaximum() {
        return sysDeliveryMaximum;
    }

    public void setSysDeliveryMaximum(Integer sysDeliveryMaximum) {
        this.sysDeliveryMaximum = sysDeliveryMaximum;
    }

    public Boolean getUcBbs() {
        return ucBbs;
    }

    public void setUcBbs(Boolean ucBbs) {
        this.ucBbs = ucBbs;
    }

    public String getUcApi() {
        return ucApi;
    }

    public void setUcApi(String ucApi) {
        this.ucApi = ucApi == null ? null : ucApi.trim();
    }

    public String getUcAppid() {
        return ucAppid;
    }

    public void setUcAppid(String ucAppid) {
        this.ucAppid = ucAppid == null ? null : ucAppid.trim();
    }

    public String getUcDatabase() {
        return ucDatabase;
    }

    public void setUcDatabase(String ucDatabase) {
        this.ucDatabase = ucDatabase == null ? null : ucDatabase.trim();
    }

    public String getUcDatabasePort() {
        return ucDatabasePort;
    }

    public void setUcDatabasePort(String ucDatabasePort) {
        this.ucDatabasePort = ucDatabasePort == null ? null : ucDatabasePort.trim();
    }

    public String getUcDatabasePws() {
        return ucDatabasePws;
    }

    public void setUcDatabasePws(String ucDatabasePws) {
        this.ucDatabasePws = ucDatabasePws == null ? null : ucDatabasePws.trim();
    }

    public String getUcDatabaseUrl() {
        return ucDatabaseUrl;
    }

    public void setUcDatabaseUrl(String ucDatabaseUrl) {
        this.ucDatabaseUrl = ucDatabaseUrl == null ? null : ucDatabaseUrl.trim();
    }

    public String getUcDatabaseUsername() {
        return ucDatabaseUsername;
    }

    public void setUcDatabaseUsername(String ucDatabaseUsername) {
        this.ucDatabaseUsername = ucDatabaseUsername == null ? null : ucDatabaseUsername.trim();
    }

    public String getUcIp() {
        return ucIp;
    }

    public void setUcIp(String ucIp) {
        this.ucIp = ucIp == null ? null : ucIp.trim();
    }

    public String getUcKey() {
        return ucKey;
    }

    public void setUcKey(String ucKey) {
        this.ucKey = ucKey == null ? null : ucKey.trim();
    }

    public String getUcTablePreffix() {
        return ucTablePreffix;
    }

    public void setUcTablePreffix(String ucTablePreffix) {
        this.ucTablePreffix = ucTablePreffix == null ? null : ucTablePreffix.trim();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public Integer getBargainValidity() {
        return bargainValidity;
    }

    public void setBargainValidity(Integer bargainValidity) {
        this.bargainValidity = bargainValidity;
    }

    public Integer getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Integer deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryTitle() {
        return deliveryTitle;
    }

    public void setDeliveryTitle(String deliveryTitle) {
        this.deliveryTitle = deliveryTitle == null ? null : deliveryTitle.trim();
    }

    public String getWebsitecss() {
        return websitecss;
    }

    public void setWebsitecss(String websitecss) {
        this.websitecss = websitecss == null ? null : websitecss.trim();
    }

    public Integer getCombinAmount() {
        return combinAmount;
    }

    public void setCombinAmount(Integer combinAmount) {
        this.combinAmount = combinAmount;
    }

    public Integer getCombinCount() {
        return combinCount;
    }

    public void setCombinCount(Integer combinCount) {
        this.combinCount = combinCount;
    }

    public Integer getZtcGoodsView() {
        return ztcGoodsView;
    }

    public void setZtcGoodsView(Integer ztcGoodsView) {
        this.ztcGoodsView = ztcGoodsView;
    }

    public Integer getAutoOrderEvaluate() {
        return autoOrderEvaluate;
    }

    public void setAutoOrderEvaluate(Integer autoOrderEvaluate) {
        this.autoOrderEvaluate = autoOrderEvaluate;
    }

    public Integer getAutoOrderReturn() {
        return autoOrderReturn;
    }

    public void setAutoOrderReturn(Integer autoOrderReturn) {
        this.autoOrderReturn = autoOrderReturn;
    }

    public Boolean getWeixinStore() {
        return weixinStore;
    }

    public void setWeixinStore(Boolean weixinStore) {
        this.weixinStore = weixinStore;
    }

    public Integer getWeixinAmount() {
        return weixinAmount;
    }

    public void setWeixinAmount(Integer weixinAmount) {
        this.weixinAmount = weixinAmount;
    }

    public Integer getConfigPaymentType() {
        return configPaymentType;
    }

    public void setConfigPaymentType(Integer configPaymentType) {
        this.configPaymentType = configPaymentType;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount == null ? null : weixinAccount.trim();
    }

    public String getWeixinAppid() {
        return weixinAppid;
    }

    public void setWeixinAppid(String weixinAppid) {
        this.weixinAppid = weixinAppid == null ? null : weixinAppid.trim();
    }

    public String getWeixinAppsecret() {
        return weixinAppsecret;
    }

    public void setWeixinAppsecret(String weixinAppsecret) {
        this.weixinAppsecret = weixinAppsecret == null ? null : weixinAppsecret.trim();
    }

    public String getWeixinToken() {
        return weixinToken;
    }

    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken == null ? null : weixinToken.trim();
    }

    public Long getStoreWeixinLogoId() {
        return storeWeixinLogoId;
    }

    public void setStoreWeixinLogoId(Long storeWeixinLogoId) {
        this.storeWeixinLogoId = storeWeixinLogoId;
    }

    public Long getWeixinQrImgId() {
        return weixinQrImgId;
    }

    public void setWeixinQrImgId(Long weixinQrImgId) {
        this.weixinQrImgId = weixinQrImgId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public ShoppingAccessory getGoodsImage() {
        return this.goodsImage;
    }
}
