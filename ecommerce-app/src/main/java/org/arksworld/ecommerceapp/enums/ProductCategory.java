package org.arksworld.ecommerceapp.enums;

public enum ProductCategory {
  SmartPhone(1001),
  Book(1002);

  final int categoryId;

  ProductCategory(int id) {
    this.categoryId = id;
  }

  public int getCategoryId() {
    return this.categoryId;
  }

  public int getId() {
    return this.categoryId;
  }

  public String getName() {
    return this.name();
  }
}
