package org.arksworld.ecommerceapp.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.entity.Order;
import org.arksworld.ecommerceapp.entity.OrderItem;

public interface OrderDao {
  public String saveOrder(int userId, Map<Integer, CartItem> cart, BigDecimal totalAmount,
                          String name, String contact, String address);

  public List<Order> findOrdersByUserId(int userId);

  public List<OrderItem> findOrderItemsByOrderId(String orderId);

}
