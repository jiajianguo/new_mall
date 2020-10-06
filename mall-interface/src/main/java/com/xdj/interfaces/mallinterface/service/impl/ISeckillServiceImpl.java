package com.xdj.interfaces.mallinterface.service.impl;

import com.xdj.interfaces.mallinterface.mapper.ShoppingSecondsKillMapper;
import com.xdj.interfaces.mallinterface.service.ISeckillService;
import com.xdj.www.entity.ShoppingSecondsKill;
import com.xdj.www.entity.ShoppingSecondsKillExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service("seckillService")
public class ISeckillServiceImpl implements ISeckillService {
    @Resource
    private ShoppingSecondsKillMapper dao;


    @Override
    public Long selectExample(ShoppingSecondsKillExample example) {
        return dao.countByExample(example);
    }

    @Override
    public ShoppingSecondsKill getObjById(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public void update(ShoppingSecondsKill sec) {
        dao.updateByPrimaryKey(sec);
    }

    @Override
    public List<ShoppingSecondsKill> queryByCondition(Map params) {
        return dao.queryByCondition(params);
    }
}
