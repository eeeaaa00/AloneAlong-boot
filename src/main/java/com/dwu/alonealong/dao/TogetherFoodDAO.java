package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherFood;

public interface TogetherFoodDAO {
	void insertTogetherFood(TogetherFood togetherFood) throws DataAccessException;
	
	void updateTogetherFood(TogetherFood togetherFood) throws DataAccessException;
	
	void deleteTogetherFood(String togId) throws DataAccessException;
	
	List<TogetherFood> getTogetherFoodListByTogId(String togId) throws DataAccessException;
}
