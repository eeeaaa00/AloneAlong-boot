package com.dwu.alonealong.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherMapper;
import com.dwu.alonealong.domain.Together;

@Repository
public class MybatisTogetherDAO implements TogetherDAO {
	@Autowired
	private TogetherMapper togetherMapper; 
	
	@Override
	public Together getTogetherByTodId(String togId) throws DataAccessException {
		return togetherMapper.getTogetherByTogId(togId);
	}

	@Override
	public void insertTogether(Together together) throws DataAccessException {
		togetherMapper.insertTogether(together);
	}

	@Override
	public void removeTogether(Together together) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTogether(Together together) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Together> getTogetherList() throws DataAccessException {
		return togetherMapper.getTogetherList();
	}

	@Override
	public List<Together> getTogetherListByCategory(String area, Date date, String kind, int price, String sex, int age)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
