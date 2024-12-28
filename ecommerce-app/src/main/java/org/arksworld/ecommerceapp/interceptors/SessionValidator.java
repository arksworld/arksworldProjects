package org.arksworld.ecommerceapp.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionValidator {
  public static boolean isValidSession(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    return session != null && session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
  }

  public static void redirectToLogin(HttpServletResponse response) throws Exception {
    response.sendRedirect("login.jsp");
  }
}

