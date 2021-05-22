package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherFoodDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherFoodMapper;
import com.dwu.alonealong.domain.TogetherFood;

@Repository
public class MybatisTogetherFoodDAO implements TogetherFoodDAO {
	
	private TogetherFoodMapper togetherFoodMapper;

	@Override
	public void insertTogetherFood(TogetherFood togetherFood) throws DataAccessException {
		togetherFoodMapper.insertTogetherFood(togetherFood);
	}

	@Override
	public void updateTogetherFood(TogetherFood togetherFood) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTogetherFood(TogetherFood togetherFood) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TogetherFood> getTogetherFoodListByTogId(String togId) throws DataAccessException {
		return togetherFoodMapper.getTogetherFoodListByTogId(togId);
	}

}
