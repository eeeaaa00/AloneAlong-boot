package com.dwu.alonealong.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherOrderDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherOrderMapper;
import com.dwu.alonealong.domain.TogetherOrder;

@Repository
public class MyBatisTogetherOrderDAO implements TogetherOrderDAO{
	@Autowired
	private TogetherOrderMapper togetherOrderMapper;

	@Override
	public void insertTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException {
		togetherOrderMapper.insertTogetherOrder(togetherOrder);
	}

	@Override
	public void removeTogetherOrder(TogetherOrder togetherOrder) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	
}
