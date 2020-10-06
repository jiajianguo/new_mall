package com.xdj.interfaces.mallinterface.service.impl;

import com.xdj.interfaces.mallinterface.service.GoodsService;
import com.xdj.interfaces.mallinterface.service.IGoodsService;
import com.xdj.interfaces.mallinterface.service.LuceneService;
import com.xdj.interfaces.mallinterface.util.LuceneVo;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.ShoppingGoodsWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
@Service("/goodsService")
public class GoodsServicesImpl implements GoodsService {

    @Autowired
    private IGoodsService iGoodsService;
    @Autowired
    private LuceneService luceneService;


    @Override
    public void synProductCreatIndex() throws IOException {
        // 获取所有的productList
        Map params = new HashMap();
        params.put( "goods_status", Integer.valueOf( 0 ) );
        List<ShoppingGoodsWithBLOBs> goods_list = this.iGoodsService.queryByCondition(params);
        List<LuceneVo> goods_vo_list = new ArrayList();
        LuceneVo vo;
        for( ShoppingGoodsWithBLOBs goods : goods_list ) {
            vo = new LuceneVo();
            vo.setVo_id( goods.getId() );
            vo.setVo_title( goods.getGoodsName() );
            vo.setVo_content( goods.getGoodsDetails() );
            vo.setVo_type( "goods" );
            vo.setVo_store_price( CommUtil.null2Float( goods.getStorePrice() ) );
            vo.setVo_add_time( goods.getAddtime().getTime() );
            vo.setVo_goods_salenum( goods.getGoodsSalenum() );
            goods_vo_list.add( vo );
        }
        luceneService.createProductIndex(goods_vo_list);
    }
}
