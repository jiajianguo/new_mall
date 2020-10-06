package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingGroup extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date begintime;

    private Date endtime;

    private String groupName;

    private Date joinendtime;

    private Integer status;

    private List<ShoppingGroupGoods> ggGoods;

    public List<ShoppingGroupGoods> getGgGoods() {
        return ggGoods;
    }

    public void setGgGoods(List<ShoppingGroupGoods> ggGoods) {
        this.ggGoods = ggGoods;
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

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Date getJoinendtime() {
        return joinendtime;
    }

    public void setJoinendtime(Date joinendtime) {
        this.joinendtime = joinendtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
