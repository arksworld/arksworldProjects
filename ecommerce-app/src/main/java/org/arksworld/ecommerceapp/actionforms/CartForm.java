package org.arksworld.ecommerceapp.actionforms;

import org.apache.struts.action.ActionForm;

public class CartForm extends ActionForm {
  private int productId;
  private int quantity;

  // Getters and Setters
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
}
