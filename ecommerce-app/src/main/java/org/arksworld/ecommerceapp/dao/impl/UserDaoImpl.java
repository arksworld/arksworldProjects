package org.arksworld.ecommerceapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.arksworld.ecommerceapp.dao.UserDao;
import org.arksworld.ecommerceapp.entity.User;
import org.arksworld.ecommerceapp.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository

public class UserDaoImpl implements UserDao<User> {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public User getUserByUserEmail(String email) {
    String sql = "Select id, username, email, role from users where email = ?";
    return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
  }

  @Override
  public void createUser(User user) {
    String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
    jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(),
        Role.USER.name());
  }

  @Override
  public boolean emailExists(String email) {
    System.out.println("Querying email..");
    String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
    System.out.println("Got count:" + count);
    return count != null && count > 0;
  }

  public boolean authenticateUser(String email, String password) {
    String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
    return count != null && count > 0;
  }

  @Override
  public String getPasswordByEmail(String email) {
    String sql = "SELECT password FROM users WHERE email = ?";
    try {
      return jdbcTemplate.queryForObject(sql, String.class, email);
    } catch (Exception e) {
      return null; // Email not found
    }
  }

  @Override
  public Role getRoleByEmail(String email) {
    String sql = "SELECT role FROM users WHERE email = ?";
    try {
      String roleName = jdbcTemplate.queryForObject(sql, String.class, email);
      return Role.valueOf(roleName);
    } catch (Exception e) {
      return null; // Email not found
    }
  }

  private static class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
      User user = new User();
      user.setUserId(resultSet.getInt("id"));
      user.setUsername(resultSet.getString("username"));
      user.setEmail(resultSet.getString("email"));
      String roleStr = resultSet.getString("role");
      if (roleStr != null) {
        user.setRole(Role.valueOf(roleStr));
      }
      return user;
    }
  }
}
