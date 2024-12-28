package org.arksworld.ecommerceapp.entity;

import java.math.BigDecimal;

public class OrderItem {
  private String orderId;
  private int productId;
  private int quantity;
  private BigDecimal price;
  private String productName;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductName() {
    return productName;
  }

  public BigDecimal getTotalPrice() {
    return getPrice().multiply(new BigDecimal(getQuantity()));
  }
}
