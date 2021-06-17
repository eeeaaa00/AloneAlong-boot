package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherFood;

@Mapper
public interface TogetherFoodMapper {
	List<TogetherFood> getTogetherFoodListByTogId(String togId) throws DataAccessException;
	void insertTogetherFood(TogetherFood togetherFood) throws DataAccessException;
	void deleteTogetherFood(String togId) throws DataAccessException;
	void updateTogetherFood(TogetherFood togetherFood) throws DataAccessException;
}
