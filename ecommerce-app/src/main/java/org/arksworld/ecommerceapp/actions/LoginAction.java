package org.arksworld.ecommerceapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.arksworld.ecommerceapp.entity.User;
import org.arksworld.ecommerceapp.enums.Role;
import org.arksworld.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class LoginAction extends BaseAction {

  @Autowired
  private UserService userService;

  public LoginAction(UserService userService) {
    this.userService = userService;
  }

  public LoginAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }
  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    boolean success = userService.login(email, password);
    if (success) {

      User user = userService.getUserByUserEmail(email);
      // Create a session and store user details
      HttpSession session = request.getSession(true);
      session.setAttribute("userEmail", email); // Store user's email in session
      session.setAttribute("isLoggedIn", true); // Flag indicating the user is logged in
      session.setAttribute("role", user.getRole().name());
      session.setAttribute("userId", user.getUserId());

      if(Role.USER.equals(user.getRole())) {
        return mapping.findForward("browseProducts");
      } else if(Role.ADMIN.equals(user.getRole())) {
        return mapping.findForward("adminDashboard");
      }
      return mapping.findForward("failure");
    } else {
      request.setAttribute("message", "Invalid email or password.");
      return mapping.findForward("failure");
    }
  }
}
