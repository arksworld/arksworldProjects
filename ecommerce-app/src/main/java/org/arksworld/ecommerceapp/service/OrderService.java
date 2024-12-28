package org.arksworld.ecommerceapp.service;

import java.util.List;
import java.util.Map;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.entity.Order;
import org.arksworld.ecommerceapp.entity.OrderItem;

public interface OrderService {
  public String placeOrder(int userId, Map<Integer, CartItem> cart, String name, String address,
                           String contact);

  public List<Order> findOrdersByUserId(int userId);

  public List<OrderItem> findOrderItemsByOrderId(String orderId);
}
