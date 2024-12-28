package org.arksworld.ecommerceapp;

import org.arksworld.ecommerceapp.dto.UserDto;
import org.arksworld.ecommerceapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EcommerceApplication {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "src/main/webapp/WEB-INF/spring-context.xml");

    UserService userService = context.getBean(UserService.class);

    UserDto userDto = new UserDto();
    userDto.setUsername("testUser");
    userDto.setPassword("password124");
    userDto.setEmail("test@example.com");


    userService.createUser(userDto);
    System.out.println("Registration success: ");
  }
}
