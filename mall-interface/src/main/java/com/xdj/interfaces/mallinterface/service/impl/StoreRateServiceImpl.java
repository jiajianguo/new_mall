package com.xdj.interfaces.mallinterface.service.impl;

import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreRateMapper;
import com.xdj.interfaces.mallinterface.service.IStoreRateService;
import com.xdj.www.entity.ShoppingStoreRate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StoreRateServiceImpl implements IStoreRateService {
	@Resource
	private ShoppingStoreRateMapper storeRateMapper;


	@Override
	public boolean save(ShoppingStoreRate storeRate) {
		try
		{
			this.storeRateMapper.insertSelective(storeRate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}return false;
	}

	@Override
	public ShoppingStoreRate getObjById(Long paramLong)
	{
		ShoppingStoreRate storeRate = this.storeRateMapper.selectByPrimaryKey(paramLong);
		if (storeRate != null) {
			return storeRate;
		}
		return null;
	}

	@Override
	public boolean delete(Long paramLong) {
		{
			try {
				this.storeRateMapper.deleteByPrimaryKey(paramLong);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}return false;
		}
	}

	@Override
	public boolean update(ShoppingStoreRate storeRate) {
		try {
			this.storeRateMapper.updateByPrimaryKey(storeRate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}return false;
	}

}
