package org.arksworld.ecommerceapp.actions.user.order;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.arksworld.ecommerceapp.entity.OrderItem;
import org.arksworld.ecommerceapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class ViewOrderDetailsAction extends Action {
  @Autowired
  private OrderService orderService;

  public ViewOrderDetailsAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) {
    String orderId = request.getParameter("orderId");
    List<OrderItem> orderItems = orderService.findOrderItemsByOrderId(orderId);
    request.setAttribute("orderItems", orderItems);

    return mapping.findForward("success");
  }
}

