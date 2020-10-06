package com.xdj.interfaces.mallinterface.service.impl;


import com.xdj.interfaces.mallinterface.mapper.ShoppingGroupAreaMapper;
import com.xdj.interfaces.mallinterface.service.IGroupAreaService;
import com.xdj.www.entity.ShoppingGroupArea;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class GroupAreaServiceImpl implements IGroupAreaService {

	@Resource
	private ShoppingGroupAreaMapper groupAreaDao;

	@Override
	@CachePut(cacheNames = "insertgroupArea",condition = "#groupArea != null")
	public boolean save(ShoppingGroupArea groupArea) {
		try {
			this.groupAreaDao.insertSelective(groupArea);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Cacheable(cacheNames = "groupArea",condition = "#id !=  null",unless = "#result==null")
	public ShoppingGroupArea getObjById(Long id) {
		ShoppingGroupArea groupArea = this.groupAreaDao.selectByPrimaryKey(id);
		if (groupArea != null) {
			return groupArea;
		}
		return null;
	}

	@Override
	@CacheEvict(cacheNames = "delgroupArea",allEntries = true,beforeInvocation = true,condition = "#id != null")
	public boolean delete(Long id) {
		try {
			this.groupAreaDao.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@CacheEvict(cacheNames = "delsgroupArea",allEntries = true,beforeInvocation = true,condition = "#groupAreaIds != null")
	public boolean batchDelete(List<Long> groupAreaIds) {
		for (Long id : groupAreaIds) {
			delete( id);
		}
		return true;
	}


	@Override
	@CachePut(cacheNames = "updategroupArea",condition = "#groupArea != null")
	public boolean update(ShoppingGroupArea groupArea) {
		try {
			this.groupAreaDao.updateByPrimaryKeySelective(groupArea);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Cacheable(cacheNames = "conditiongroupArea",unless = "#result==null")
	public List<ShoppingGroupArea> queryByCondition(Map<String, Object> params) {
		return groupAreaDao.queryByCondition(params);
	}


}
