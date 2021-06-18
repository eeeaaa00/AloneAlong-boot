package com.dwu.alonealong.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;


import com.dwu.alonealong.dao.UserDAO;
import com.dwu.alonealong.dao.mybatis.mapper.UserMapper;
import com.dwu.alonealong.domain.User;


@Repository
public class MybatisUserDAO implements UserDAO {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByUserId(String Id){
		// TODO Auto-generated method stub
		return userMapper.getUserByUserId(Id);
	}

	@Override
	public User getUserByUserIdAndPassword(String Id, String pw) throws DataAccessException {
		return userMapper.getUserByUserIdAndPassword(Id,pw);
	}

	@Override
	public void createUser(User user) {
			//throws com.dwu.alonealong.dao.DataAccessException {
		userMapper.createUser(user);
	}

	@Override
	public void updateUser(User user) {
			//throws com.dwu.alonealong.dao.DataAccessException {
		if (user.getPw() != null && user.getPw().length() > 0) 
		{
			userMapper.updateUser(user);
		}
	}

	@Override
	public List<String> getUserIdList() {
			//throws com.dwu.alonealong.dao.DataAccessException {
		return userMapper.getUserIdList();
	}

	@Override
	public void removeUser(String Id) {
		// TODO Auto-generated method stub
		userMapper.removeUser(Id);
	}
	
	public void insertContact(String contents) {
		userMapper.insertContact(contents);
	}
}