package com.dwu.alonealong.dao;

import java.util.List;


import com.dwu.alonealong.domain.User;


public interface UserDao {

  User getUser(String Id); //throws DataAccessException;

  User getUser(String Id, String password);

  void createUser(User user);

  void updateUser(User user);
  
  void removeUser(String Id);

  List<String> getUserIdList();
  
  //void createBuissnessNum(User user);

}
