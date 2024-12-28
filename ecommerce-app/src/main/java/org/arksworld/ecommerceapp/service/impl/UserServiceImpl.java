package org.arksworld.ecommerceapp.service.impl;

import org.arksworld.ecommerceapp.dao.UserDao;
import org.arksworld.ecommerceapp.dto.UserDto;
import org.arksworld.ecommerceapp.entity.User;
import org.arksworld.ecommerceapp.enums.Role;
import org.arksworld.ecommerceapp.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao<User> userDao;

  public boolean login(String email, String password) {
    String storedHashedPassword = userDao.getPasswordByEmail(email);
    return storedHashedPassword != null && BCrypt.checkpw(password, storedHashedPassword);
  }

  @Override
  public Role getUserRoleByEmail(String email) {
    return userDao.getRoleByEmail(email);
  }

  @Override
  public User getUserByUserEmail(String email) {
    return userDao.getUserByUserEmail(email);
  }

  @Override
  public void createUser(UserDto userDto) {

    if(!userDao.emailExists(userDto.getEmail()))  {
      User user = new User();
      user.setUsername(userDto.getUsername());
      // Hash the password using BCrypt
      String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());

      user.setPassword(hashedPassword);
      user.setEmail(userDto.getEmail());
      userDao.createUser(user);
    } else {
      throw new RuntimeException("User with email " + userDto.getEmail() + " already exists.");
    }
  }
}
