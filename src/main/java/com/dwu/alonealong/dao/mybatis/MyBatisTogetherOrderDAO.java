package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherOrderDAO;
import com.dwu.alonealong.dao.mybatis.mapper.RestaurantMapper;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherOrderMapper;
import com.dwu.alonealong.domain.TogetherOrder;

@Repository
public class MyBatisTogetherOrderDAO implements TogetherOrderDAO{
	@Autowired
	private TogetherOrderMapper togetherOrderMapper;
	@Autowired
	private RestaurantMapper restaurantMapper;

	@Override
	public void insertTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException {
		togetherOrderMapper.insertTogetherOrder(togetherOrder);
	}

	@Override
	public void deleteTogetherOrder(String togId) throws DataAccessException {
		togetherOrderMapper.deleteTogetherOrder(togId);
	}

	@Override
	public List<TogetherOrder> getTogetherOrderByUserId(String userId) throws DataAccessException {
		List<TogetherOrder> togetherOrderList = togetherOrderMapper.getTogetherOrderByUserId(userId);
		
		for(int i = 0; i < togetherOrderList.size(); i++) {
			String resId = togetherOrderList.get(i).getTogether().getResId();
			togetherOrderList.get(i).getTogether().setRestaurant(restaurantMapper.getRestaurant(resId));
		}
		
		return togetherOrderList;
	}

	@Override
	public List<TogetherOrder> getTogetherOrderByTogId(String togId) throws DataAccessException {
		return togetherOrderMapper.getTogetherOrderByTogId(togId);
	}
	
}
