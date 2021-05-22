package com.dwu.alonealong.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.TogetherMember;

@Mapper
public interface TogetherMemberMapper {
	List<TogetherMember> getTogetherMemberListByTogId() throws DataAccessException;
	void insertTogetherMember(TogetherMember togetherMember) throws DataAccessException;
}
