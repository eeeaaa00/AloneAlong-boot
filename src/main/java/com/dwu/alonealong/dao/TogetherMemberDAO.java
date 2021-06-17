package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherMember ;

public interface TogetherMemberDAO {
	
	void insertTogetherMember(TogetherMember togetherMember) throws DataAccessException;
	
	void updateTogetherMember(TogetherMember togetherMember) throws DataAccessException;
	
	void deleteTogetherMember(String togId) throws DataAccessException;
	
	List<TogetherMember> getTogetherMemberListByTogId(String togId) throws DataAccessException;
	
}
