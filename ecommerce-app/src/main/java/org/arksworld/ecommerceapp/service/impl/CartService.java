package org.arksworld.ecommerceapp.service.impl;

import java.util.Map;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.entity.Product;

public interface CartService {
  public void addToCart(Map<Integer, CartItem> cart, Product product, int quantity);
  public void updateCartItem(Map<Integer, CartItem> cart, int productId, int quantity);
  public void removeFromCart(Map<Integer, CartItem> cart, int productId);
}
