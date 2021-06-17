package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherFoodDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherFoodMapper;
import com.dwu.alonealong.domain.TogetherFood;

@Repository
public class MybatisTogetherFoodDAO implements TogetherFoodDAO {
	@Autowired
	private TogetherFoodMapper togetherFoodMapper;

	@Override
	public void insertTogetherFood(TogetherFood togetherFood) throws DataAccessException {
		togetherFoodMapper.insertTogetherFood(togetherFood);
	}

	@Override
	public void updateTogetherFood(TogetherFood togetherFood) throws DataAccessException {
		togetherFoodMapper.updateTogetherFood(togetherFood);
	}

	@Override
	public void deleteTogetherFood(String togId) throws DataAccessException {
		togetherFoodMapper.deleteTogetherFood(togId);
	}

	@Override
	public List<TogetherFood> getTogetherFoodListByTogId(String togId) throws DataAccessException {
		return togetherFoodMapper.getTogetherFoodListByTogId(togId);
	}

}
