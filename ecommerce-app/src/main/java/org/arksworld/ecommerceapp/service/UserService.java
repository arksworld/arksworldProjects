package org.arksworld.ecommerceapp.service;

import org.arksworld.ecommerceapp.dto.UserDto;
import org.arksworld.ecommerceapp.entity.User;
import org.arksworld.ecommerceapp.enums.Role;

public interface UserService {

  public User getUserByUserEmail(String email);
  public void createUser(UserDto userDto);
  public boolean login(String email, String password);
  public Role getUserRoleByEmail(String email);

}
