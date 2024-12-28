package org.arksworld.ecommerceapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.arksworld.ecommerceapp.dao.OrderDao;
import org.arksworld.ecommerceapp.entity.CartItem;
import org.arksworld.ecommerceapp.entity.Order;
import org.arksworld.ecommerceapp.entity.OrderItem;
import org.arksworld.ecommerceapp.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public String saveOrder(int userId, Map<Integer, CartItem> cart, BigDecimal totalAmount,
                          String name,
                          String contact, String address) {
    // Save the order
    String orderId = UUID.randomUUID().toString();
    String orderSql =
        "INSERT INTO orders (order_id, user_id, total_amount, billing_name, contact, billing_address) VALUES (?, ?, ?,?,?,?)";
    jdbcTemplate.update(orderSql, orderId, userId, totalAmount, name, contact, address);


    // Save order items
    String itemSql =
        "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
    for (CartItem item : cart.values()) {
      jdbcTemplate.update(itemSql, orderId, item.getProductId(), item.getQuantity(),
          item.getPrice());
    }

    return orderId;
  }

  public List<Order> findOrdersByUserId(int userId) {
    String sql =
        "SELECT order_id, total_amount, order_date, billing_name, billing_address, contact,status FROM orders WHERE user_id = ?";
    return jdbcTemplate.query(sql, new OrderRowMapper(), userId);
  }

  public List<OrderItem> findOrderItemsByOrderId(String orderId) {
    String sql = "SELECT oi.order_id, oi.product_id, p.name as product_name, oi.quantity, oi.price " +
        "FROM order_items oi " +
        "JOIN products p ON oi.product_id = p.id " +
        "WHERE oi.order_id = ?";
    return jdbcTemplate.query(sql, new OrderItemRowMapper(), orderId);
  }

  private static class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
      Order order = new Order();
      order.setOrderId(resultSet.getString("order_id"));
      order.setTotalAmount(resultSet.getBigDecimal("total_amount"));
      order.setOrderStatus(OrderStatus.valueOf(resultSet.getString("status")));
      order.setOrderDateTime(resultSet.getTimestamp("order_date"));
      order.setBillingName(resultSet.getString("billing_name"));
      order.setBillingContact(resultSet.getString("contact"));
      order.setBillingAddress(resultSet.getString("billing_address"));
      return order;
    }
  }

  private static class OrderItemRowMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
      OrderItem orderItem = new OrderItem();
      orderItem.setOrderId(resultSet.getString("order_id"));
      orderItem.setProductId(resultSet.getInt("product_id"));
      orderItem.setQuantity(resultSet.getInt("quantity"));
      orderItem.setPrice(resultSet.getBigDecimal("price"));
      orderItem.setProductName(resultSet.getString("product_name"));
      return orderItem;
    }
  }
}
