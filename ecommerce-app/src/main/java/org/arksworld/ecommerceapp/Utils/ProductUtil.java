package org.arksworld.ecommerceapp.Utils;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.arksworld.ecommerceapp.entity.CartItem;

public class ProductUtil {

  private ProductUtil() {

  }

  public static void updateCartItemCount(Map<Integer, CartItem> cart, HttpSession session) {
    int totalItems = cart.values().stream().mapToInt(CartItem::getQuantity).sum();
    if (totalItems > 0) {
      session.setAttribute("cartItemCount", totalItems);
    } else {
      session.removeAttribute("cartItemCount");
    }
  }

  public static void clearCartInfo(HttpSession session) {
    session.removeAttribute("cart");
    session.removeAttribute("cartEntries");
    session.removeAttribute("cartItemCount");
  }
}
