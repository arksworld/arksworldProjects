package org.arksworld.ecommerceapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.arksworld.ecommerceapp.dto.UserDto;
import org.arksworld.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class RegisterAction extends BaseAction {

  @Autowired
  private  UserService userService;

  public RegisterAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  public RegisterAction(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    UserDto userDto = new UserDto(username, email, password);
    try {
      userService.createUser(userDto);
      System.out.println("User created");
      request.setAttribute("message", "Registration successful!");
      return mapping.findForward("success");
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("message", "Email already exists!");
      return mapping.findForward("failure");
    }

  }
}
