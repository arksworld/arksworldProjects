package org.arksworld.ecommerceapp.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.arksworld.ecommerceapp.dao.OrderDao;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.entity.Order;
import org.arksworld.ecommerceapp.entity.OrderItem;
import org.arksworld.ecommerceapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderDao orderDao;


  @Override
  public String placeOrder(int userId, Map<Integer, CartItem> cart, String name, String address,
                           String contact) {
    BigDecimal totalAmount = cart.values().stream()
        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return orderDao.saveOrder(userId, cart, totalAmount, name, contact, address);
  }

  @Override
  public List<Order> findOrdersByUserId(int userId) {
    return orderDao.findOrdersByUserId(userId);
  }

  @Override
  public List<OrderItem> findOrderItemsByOrderId(String orderId) {
    return orderDao.findOrderItemsByOrderId(orderId);
  }
}

