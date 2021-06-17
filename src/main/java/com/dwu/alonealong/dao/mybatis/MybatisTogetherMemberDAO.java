package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.TogetherMemberDAO;
import com.dwu.alonealong.dao.mybatis.mapper.TogetherMemberMapper;
import com.dwu.alonealong.domain.TogetherMember;

@Repository
public class MybatisTogetherMemberDAO implements TogetherMemberDAO {
	@Autowired
	private TogetherMemberMapper togetherMemberMapper; 
	
	@Override
	public void insertTogetherMember(TogetherMember togetherMember) throws DataAccessException {
		togetherMemberMapper.insertTogetherMember(togetherMember);
	}

	@Override
	public void updateTogetherMember(TogetherMember togetherMember) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTogetherMember(String togId) throws DataAccessException {
		togetherMemberMapper.deleteTogetherMember(togId);
	}

	@Override
	public List<TogetherMember> getTogetherMemberListByTogId(String togId) throws DataAccessException {
		// TODO Auto-generated method stub
		return togetherMemberMapper.getTogetherMemberListByTogId(togId);
	}
	
}
