package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.RestaurantDAO;
import com.dwu.alonealong.dao.mybatis.mapper.RestaurantMapper;
import com.dwu.alonealong.domain.Restaurant;

@Repository
public class MybatisRestaurantDAO implements RestaurantDAO{
	
	@Autowired
	private RestaurantMapper resMapper;
	
	
	public List<Restaurant> getRestaurantListByCategory(String categoryId) throws DataAccessException{ //나중에 지역분류 추가하자
		return resMapper.getRestaurantListByCategory(categoryId);
	}
	public List<Restaurant> getRestaurantList() throws DataAccessException{ //나중에 지역분류 추가하자
		return resMapper.getRestaurantList();
	}
	
	public List<Restaurant> searchRestaurantList(String keywords) throws DataAccessException{
		return resMapper.searchRestaurantList(keywords);
	}
	
	public Restaurant getRestaurant(String resId) throws DataAccessException{
		return resMapper.getRestaurant(resId);
	}
	
	
	
	
	public void insertRestaurant(Restaurant res) throws DataAccessException{
		resMapper.insertRestaurant(res);
	}
	
	public void updateRestaurant(Restaurant res) throws DataAccessException{
		resMapper.updateRestaurant(res);
	}
	
	public void deleteRestaurant(Restaurant res) throws DataAccessException{
		resMapper.deleteRestaurant(res);
	}
	 
}
