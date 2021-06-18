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
	
	
	public List<Restaurant> getRestaurantListByCategory(String category1, String category2, String sortType) throws DataAccessException{ //나중에 지역분류 추가하자
		if(category1.equals("지역")) category1 = "";
		if(category2.equals("분류")) category2 = "";
		return resMapper.getRestaurantListByCategory(category1, category2, sortType);
	}
	public List<Restaurant> getRestaurantList() throws DataAccessException{ 
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
		if(res.getImgFile().length == 0)
			resMapper.updateRestaurantWithoutImg(res);
		else
			resMapper.updateRestaurant(res);
	}
	@Override
	public void deleteRestaurant(String ownerId) throws DataAccessException {
		resMapper.deleteRestaurant(ownerId);
	}
	@Override
	public void updateAvgRating(int rating, String resId) throws DataAccessException {
		resMapper.updateAvgRating(rating, resId);
	}
	@Override
	public Restaurant getRestaurantByOwnerId(String ownerId) throws DataAccessException {
		return resMapper.getRestaurantByOwnerId(ownerId);
	}
	
	 
}
