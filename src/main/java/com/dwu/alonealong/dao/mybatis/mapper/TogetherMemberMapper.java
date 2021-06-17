package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherMember;

@Mapper
public interface TogetherMemberMapper {
	void insertTogetherMember(TogetherMember togetherMember) throws DataAccessException;
	void deleteTogetherMember(String togId) throws DataAccessException;
	List<TogetherMember> getTogetherMemberListByTogId(String togId) throws DataAccessException;
}
