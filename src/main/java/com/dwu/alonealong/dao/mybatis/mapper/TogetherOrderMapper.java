package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherOrder;

@Mapper
public interface TogetherOrderMapper {
	void insertTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException;
	
	List<TogetherOrder> getTogetherOrderByUserId(String userId) throws DataAccessException;
	
	List<TogetherOrder> getTogetherOrderByTogId(String togId) throws DataAccessException;
	
	void deleteTogetherOrder(String togId) throws DataAccessException;
}
