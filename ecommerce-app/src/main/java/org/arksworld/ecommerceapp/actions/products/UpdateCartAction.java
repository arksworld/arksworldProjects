package org.arksworld.ecommerceapp.actions.products;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class UpdateCartAction extends Action {
  @Autowired
  private CartService cartService;

  public UpdateCartAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

    int productId = Integer.parseInt(request.getParameter("productId"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));

    cartService.updateCartItem(cart, productId, quantity);
    return mapping.findForward("success");
  }
}

