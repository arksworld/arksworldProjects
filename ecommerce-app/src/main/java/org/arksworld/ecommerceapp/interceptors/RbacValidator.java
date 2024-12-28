package org.arksworld.ecommerceapp.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RbacValidator {
  public static boolean hasAccess(HttpServletRequest request, String requiredRole) {
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("isLoggedIn") == null || !(boolean) session.getAttribute("isLoggedIn")) {
      return false; // No session or not logged in
    }

    String userRole = (String) session.getAttribute("role");
    return requiredRole.equals(userRole); // Role matches
  }

  public static void redirectToAccessDenied(HttpServletResponse response) throws Exception {
    response.sendRedirect("access-denied.jsp");
  }
}

