package com.dwu.alonealong.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dwu.alonealong.domain.User;


public interface UserDAO {

  User getUserByUserId(String Id); //throws DataAccessException;

  User getUserByUserIdAndPassword(String Id, String pw) throws DataAccessException;

  void createUser(User user);

  void updateUser(User user);
  
  void removeUser(String Id);

  List<String> getUserIdList();


  void insertContact(String contents);
  //void createBuissnessNum(User user);

}
