package org.arksworld.ecommerceapp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import org.arksworld.ecommerceapp.enums.OrderStatus;

public class Order {

  private String orderId;
  private BigDecimal totalAmount;
  private OrderStatus orderStatus;
  private Timestamp orderDateTime;
  private String billingName;
  private String billingContact;
  private String billingAddress;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Timestamp getOrderDateTime() {
    return orderDateTime;
  }

  public void setOrderDateTime(Timestamp orderDateTime) {
    this.orderDateTime = orderDateTime;
  }

  public String getBillingName() {
    return billingName;
  }

  public void setBillingName(String billingName) {
    this.billingName = billingName;
  }

  public String getBillingContact() {
    return billingContact;
  }

  public void setBillingContact(String billingContact) {
    this.billingContact = billingContact;
  }

  public String getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
  }



}
