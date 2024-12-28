package org.arksworld.ecommerceapp.actions.products;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.arksworld.ecommerceapp.Utils.ProductUtil;
import org.arksworld.ecommerceapp.entity.CartItem;

public class ViewCartAction extends Action {
  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

    if (cart == null) {
      cart = new ConcurrentHashMap<>();
      session.setAttribute("cart", cart);
    }

    // Calculate the total number of items in the cart
    ProductUtil.updateCartItemCount(cart, session);

    session.setAttribute("cartentries", cart.values());

    return mapping.findForward("success");
  }
}

