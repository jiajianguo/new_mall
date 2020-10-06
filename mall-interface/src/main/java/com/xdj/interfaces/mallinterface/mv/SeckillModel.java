package com.xdj.interfaces.mallinterface.mv;


import com.xdj.www.entity.ShoppingSecondsKill;

import java.util.List;

/**
 * @author Administrator
 */
public class SeckillModel {
   private String time;

   private List<ShoppingSecondsKill> secKills;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ShoppingSecondsKill> getSecKills() {
        return secKills;
    }

    public void setSecKills(List<ShoppingSecondsKill> secKills) {
        this.secKills = secKills;
    }
}
