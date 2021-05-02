package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherOrder;

public interface TogetherOrderDAO {
	
	TogetherOrder getTogetherOrder(String userId) throws DataAccessException;
	
	List<TogetherOrder> getTogetheOrderrListByUser(String userId) throws DataAccessException;
	
	List<TogetherOrder> getTogetheOrderrListByRes(String resId) throws DataAccessException;
	
	void insertTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException;
	
	void removeTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException;
	
}
