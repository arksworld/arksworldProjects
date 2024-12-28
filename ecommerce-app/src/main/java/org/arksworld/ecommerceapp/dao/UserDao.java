package org.arksworld.ecommerceapp.dao;

import org.arksworld.ecommerceapp.entity.User;
import org.arksworld.ecommerceapp.enums.Role;

public interface UserDao<T> {


  public User getUserByUserEmail(String email);

  public void createUser(T user);

  public boolean emailExists(String email);

  public boolean authenticateUser(String email, String password);

  public String getPasswordByEmail(String email);

  public Role getRoleByEmail(String email);
  }
