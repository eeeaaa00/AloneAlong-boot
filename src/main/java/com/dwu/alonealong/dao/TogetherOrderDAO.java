package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherOrder;

public interface TogetherOrderDAO {
	
	void insertTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException;
	
	void removeTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException;
	
	List<TogetherOrder> getTogetherOrderByUserId(String userId) throws DataAccessException;
	
}
