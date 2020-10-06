package com.xdj.interfaces.mallinterface.controller.shop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xdj.interfaces.mallinterface.service.IAreaService;
import com.xdj.www.entity.ShoppingArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @RequestMapping({"/load_area.htm"})
    @ResponseBody
    public void load_area(HttpServletResponse response, String pid){
        Map params = new HashMap();
        params.put("parent_id", "=".concat(pid));
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        JSONArray list = new JSONArray();
        for (ShoppingArea area : areas) {
            JSONObject map = new JSONObject();
            map.put("id", area.getId());
            map.put("areaName", area.getAreaname());
            list.add(map);
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(list.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
