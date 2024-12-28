package org.arksworld.ecommerceapp.entity;

import java.math.BigDecimal;

public class CartItem {
  public CartItem(int productId, String name, BigDecimal price, int quantity) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public CartItem() {
  }

  private int productId;
  private String name;
  private BigDecimal price;
  private int quantity;

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
// Constructors, Getters, and Setters

  public BigDecimal getTotalPrice() {
    if(getQuantity() == 0 || BigDecimal.ZERO.equals(getPrice())) {
      return BigDecimal.ZERO;
    }
    BigDecimal quantityVal = BigDecimal.valueOf(getQuantity());
    return getPrice().multiply(quantityVal);
  }
}



