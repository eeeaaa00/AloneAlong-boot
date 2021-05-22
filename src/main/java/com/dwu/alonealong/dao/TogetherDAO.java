package com.dwu.alonealong.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.Together;

public interface TogetherDAO {
	
	Together getTogether(String togId) throws DataAccessException;
	
	void insertTogether(Together together) throws DataAccessException;
	
	void removeTogether(Together together) throws DataAccessException;
	
	void updateTogether(Together together) throws DataAccessException;
	
	List<Together> getTogetherList() throws DataAccessException;
	
	List<Together> getTogetherListByCategory(String area, Date date, String kind, int price, String sex, int age) throws DataAccessException;
}			
