package org.arksworld.ecommerceapp.service.impl;

import java.util.Map;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
  // Add a product to the cart
  public void addToCart(Map<Integer, CartItem> cart, Product product, int quantity) {

    cart.compute(product.getId(), (productId, cartItem) -> {
      if (cartItem == null) {
        return new CartItem(productId, product.getName(), product.getPrice(), quantity);
      } else {
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        return cartItem;
      }
    });
  }

  // Update the quantity of a product in the cart
  public void updateCartItem(Map<Integer, CartItem> cart, int productId, int quantity) {
    if (cart.containsKey(productId)) {
      if (quantity > 0) {
        cart.get(productId).setQuantity(quantity);
      } else {
        cart.remove(productId); // Remove item if quantity is zero
      }
    }
  }

  // Remove a product from the cart
  public void removeFromCart(Map<Integer, CartItem> cart, int productId) {
    cart.remove(productId);
  }
}

