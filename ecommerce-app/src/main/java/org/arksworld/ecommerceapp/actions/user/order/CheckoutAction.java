package org.arksworld.ecommerceapp.actions.user.order;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import org.arksworld.ecommerceapp.Utils.ProductUtil;
import org.arksworld.ecommerceapp.actionforms.CheckoutForm;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class CheckoutAction extends Action {

  @Autowired
  private OrderService orderService;

  public CheckoutAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

    if (cart == null || cart.isEmpty()) {
      request.setAttribute("message", "Your cart is empty. Add items to proceed with checkout.");
      return mapping.findForward("failure");
    }

    CheckoutForm checkoutForm = (CheckoutForm) form;


    // Save the order
    int userId = (int) session.getAttribute("userId");
    String orderId = orderService.placeOrder(userId, cart, checkoutForm.getName(), checkoutForm.getAddress(), checkoutForm.getContact());

    // Clear the cart after checkout
    ProductUtil.clearCartInfo(session);
    session.setAttribute("orderId", orderId);

    return mapping.findForward("success");
  }


}
