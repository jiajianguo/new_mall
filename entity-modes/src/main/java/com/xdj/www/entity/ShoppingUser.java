package com.xdj.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;

import java.util.*;

/**
 * @author Administrator
 */
@JsonIgnoreProperties(value = {"accountNonExpired","credentialsNonExpired","accountNonLocked","enabled"})
public class ShoppingUser extends BaseEntity implements UserDetails {
    private Long id;
    private Date addtime;
    private Boolean deletestatus;
    private String msn;

    private String qq;

    private String ww;

    private String address;

    private BigDecimal availablebalance;

    private Date birthday;

    private String email;

    private ShoppingAccessory photo;

    private ShoppingArea area;

    public ShoppingArea getArea() {
        return area;
    }

    public void setArea(ShoppingArea area) {
        this.area = area;
    }

    public ShoppingAccessory getPhoto() {
        return photo;
    }

    public void setPhoto(ShoppingAccessory photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ShoppingUser{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", msn='" + msn + '\'' +
                ", qq='" + qq + '\'' +
                ", ww='" + ww + '\'' +
                ", address='" + address + '\'' +
                ", availablebalance=" + availablebalance +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", freezeblance=" + freezeblance +
                ", gold=" + gold +
                ", integral=" + integral +
                ", lastlogindate=" + lastlogindate +
                ", lastloginip='" + lastloginip + '\'' +
                ", logincount=" + logincount +
                ", logindate=" + logindate +
                ", loginip='" + loginip + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", report=" + report +
                ", sex=" + sex +
                ", status=" + status +
                ", telephone='" + telephone + '\'' +
                ", truename='" + truename + '\'' +
                ", username='" + username + '\'' +
                ", userrole='" + userrole + '\'' +
                ", userCredit=" + userCredit +
                ", photoId=" + photoId +
                ", storeId=" + storeId +
                ", qqOpenid='" + qqOpenid + '\'' +
                ", sinaOpenid='" + sinaOpenid + '\'' +
                ", parentId=" + parentId +
                ", years=" + years +
                ", areaId=" + areaId +
                ", storeQuickMenu='" + storeQuickMenu + '\'' +
                ", store=" + store +
                '}';
    }

    private BigDecimal freezeblance;

    private Integer gold;

    private Integer integral;

    private Date lastlogindate;

    private String lastloginip;

    private Integer logincount;

    private Date logindate;

    private String loginip;

    private String mobile;

    private String password;

    private Integer report;

    private Integer sex;

    private Integer status;

    private String telephone;

    private String truename;

    private String username;

    private String userrole;

    private Integer userCredit;

    private Long photoId;

    private Long storeId;

    private String qqOpenid;

    private String sinaOpenid;

    private Long parentId;

    private Integer years;

    private Long areaId;

    private String storeQuickMenu;

    private ShoppingStore store;

    /**
     * 新加的变量
     */
    private ShoppingUserconfig userconfig;
    private List<ShoppingRole> roles;

    private Collection<? extends GrantedAuthority> authorities;

    public ShoppingStore getStore() {
        return store;
    }

    public void setStore(ShoppingStore store) {
        this.store = store;
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

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww == null ? null : ww.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(BigDecimal availablebalance) {
        this.availablebalance = availablebalance;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public BigDecimal getFreezeblance() {
        return freezeblance;
    }

    public void setFreezeblance(BigDecimal freezeblance) {
        this.freezeblance = freezeblance;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Date getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole == null ? null : userrole.trim();
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
    }

    public String getSinaOpenid() {
        return sinaOpenid;
    }

    public void setSinaOpenid(String sinaOpenid) {
        this.sinaOpenid = sinaOpenid == null ? null : sinaOpenid.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getStoreQuickMenu() {
        return storeQuickMenu;
    }

    public void setStoreQuickMenu(String storeQuickMenu) {
        this.storeQuickMenu = storeQuickMenu == null ? null : storeQuickMenu.trim();
    }


    public ShoppingUserconfig getUserconfig() {
        return userconfig;
    }

    public void setUserconfig(ShoppingUserconfig userconfig) {
        this.userconfig = userconfig;
    }

    public List<ShoppingRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ShoppingRole> roles) {
        this.roles = roles;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
