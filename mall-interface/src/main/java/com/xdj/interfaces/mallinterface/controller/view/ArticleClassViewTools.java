package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IArticleClassService;
import com.xdj.www.entity.ShoppingArticle;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ArticleClassViewTools {
    @Resource
    private IArticleClassService articleClassService;


    public void addArticleClass(ShoppingArticle art) {
        if(art != null && art.getArticleclassId() != null){
            art.setArticleClass(articleClassService.getObjById(art.getArticleclassId()));
        }
    }
}
