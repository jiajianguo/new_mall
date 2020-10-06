package com.xdj.interfaces.mallinterface.controller.buyer;

import com.alibaba.fastjson.JSONObject;
import com.xdj.interfaces.mallinterface.service.IAccessoryService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.util.FileUploadUtil;
import com.xdj.www.entity.ShoppingAccessory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
@RestController
public class ImageUploadController {

    @Resource
    private ISysConfigService configService;
    private final  static Logger log = LoggerFactory.getLogger("images");

    /**
     * 全局通用文件上传
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public final void  fileUpload(HttpServletRequest request ,HttpServletResponse response,@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        JSONObject data = new JSONObject();
        String basePath=this.configService.getSysConfig().getUploadfilepath();
        String path="";
        String prefix ="";
        int width=0;
        int height=0;
        if(File.separator.equals("/")){
            prefix="/home";
            if(type ==  null){
                //使用默认文件路径
                path ="/upload/unknow/";
                width =400;
                height=300;
            }else if("headimg".equals(type)){
                //头像之类的图片
                path = "/upload/"+type+"/";
                width =100;
                height=100;
            }else if("goods".equals(type)){
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                path ="/upload/"+type+"/"+sdf.format(new Date())+"/";
                //商品图片
                width =300;
                height=300;
            }else if("logo".equals(type)){
                //log图标
                path = "/upload/"+type+"/";
                path =FileUploadUtil.imgPath(type);
                width =100;
                height=100;
            }else if("brand".equals(type)){
                //品牌等
                path  = "/upload/"+type+"/";
                width =200;
                height=100;
            }
        }else{
            if(type ==  null){
                //使用默认文件路径
                path =request.getSession().getServletContext().getRealPath("/static/upload/") +"unknow/";
                width =400;
                height=300;
            }else if("headimg".equals(type)){
                //头像之类的图片
                path = request.getSession().getServletContext().getRealPath("") +"/upload/"+type+"/";
                width =100;
                height=100;
            }else if("goods".equals(type)){
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                path =request.getSession().getServletContext().getRealPath("/static/upload/")+type+"/"+sdf.format(new Date())+"/";
                //商品图片
                width =300;
                height=300;
            }else if("logo".equals(type)){
                //log图标
                path =request.getSession().getServletContext().getRealPath("/static/upload/")+type+"/";
                path =FileUploadUtil.imgPath(type);
                width =100;
                height=100;
            }else if("brand".equals(type)){
                //品牌等
                path  = request.getSession().getServletContext().getRealPath("/static/upload/") +type+"/";
                width =200;
                height=100;
            }
        }
        String name = System.currentTimeMillis() +file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        ShoppingAccessory accessory = new ShoppingAccessory();
        accessory.setAddtime(new Date());
        accessory.setDeletestatus(false);
        accessory.setPath(this.configService.getSysConfig().getUploadfilepath() + "/"+type);
        accessory.setName(name);
        accessory.setHeight(height);
        accessory.setInfo(type);
        accessory.setWidth(width);
        accessory.setSize(1.5f);
        //accessoryService.save(accessory);
        data.put("code","200");
        data.put("msg","success");
        data.put("data",accessory);
        FileUploadUtil.photoHandleByWidthAndHeight(file,prefix+path,name,height,width,false);
        response.getOutputStream().write(data.toJSONString().getBytes());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
