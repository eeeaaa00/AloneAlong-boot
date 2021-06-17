package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Together;

public interface TogetherDAO {
	
	Together getTogetherByTodId(String togId) throws DataAccessException;
	
	void insertTogether(Together together) throws DataAccessException;
	
	void deleteTogether(String togId) throws DataAccessException;
	
	void updateTogether(Together together) throws DataAccessException;
	
	List<Together> getTogetherList() throws DataAccessException;
	
	List<Together> searchTogetherList(String keyword) throws DataAccessException;
	
	List<Together> getTogetherListByCategory(String area, String date, String kind, int price, String sex, String age) throws DataAccessException;
	
	List<Together> recommandTogetherList(String sex, String address) throws DataAccessException;
	
	List<Together> getTogetherListByResId(String resId) throws DataAccessException;
}			
