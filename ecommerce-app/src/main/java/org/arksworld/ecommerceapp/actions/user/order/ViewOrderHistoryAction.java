package org.arksworld.ecommerceapp.actions.user.order;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.arksworld.ecommerceapp.entity.Order;
import org.arksworld.ecommerceapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class ViewOrderHistoryAction extends Action {
  @Autowired
  private  OrderService orderService;

  public ViewOrderHistoryAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) {
    HttpSession session = request.getSession();
    Integer userId = (Integer) session.getAttribute("userId");

    if (userId == null) {
      return mapping.findForward("login");
    }

    List<Order> orders = orderService.findOrdersByUserId(userId);
    request.setAttribute("orders", orders);

    return mapping.findForward("success");
  }
}

