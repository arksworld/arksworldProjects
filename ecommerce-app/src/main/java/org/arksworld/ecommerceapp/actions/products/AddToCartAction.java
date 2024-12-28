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
import org.arksworld.ecommerceapp.entity.Product;
import org.arksworld.ecommerceapp.service.ProductService;
import org.arksworld.ecommerceapp.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class AddToCartAction extends Action {

  @Autowired
  private ProductService productService;
  @Autowired
  private CartService cartService;

  public AddToCartAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) {
    HttpSession session = request.getSession();
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
    if (cart == null) {
      cart = new ConcurrentHashMap<>();
      session.setAttribute("cart", cart);
    }

    int productId = Integer.parseInt(request.getParameter("productId"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));

    Product product = productService.getProductById(productId);
    if (product != null) {
      cartService.addToCart(cart, product, quantity);
    }

    // Calculate the total number of items in the cart
    ProductUtil.updateCartItemCount(cart, session);

    return mapping.findForward("success");
  }


}

