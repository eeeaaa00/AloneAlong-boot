package com.dwu.alonealong.dao.mybatis;

import java.util.List;

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
	public void deleteTogetherOrder(String togId) throws DataAccessException {
		togetherOrderMapper.deleteTogetherOrder(togId);
	}

	@Override
	public List<TogetherOrder> getTogetherOrderByUserId(String userId) throws DataAccessException {
		return togetherOrderMapper.getTogetherOrderByUserId(userId);
	}

	@Override
	public List<TogetherOrder> getTogetherOrderByTogId(String togId) throws DataAccessException {
		return togetherOrderMapper.getTogetherOrderByTogId(togId);
	}
	
}
