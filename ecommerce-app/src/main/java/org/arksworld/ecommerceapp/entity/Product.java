package org.arksworld.ecommerceapp.entity;

import java.math.BigDecimal;
import java.util.Base64;

public class Product {
  private int id;
  private String name;
  private String description;
  private BigDecimal price;
  private int categoryId;
  private int stock;
  private byte[] productImage;
  private String imageUrl;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public byte[] getProductImage() {
    return productImage;
  }

  public void setProductImage(byte[] productImage) {
    this.productImage = productImage;
  }

  public String getImageBase64() {
    if (getProductImage() != null) {
      return Base64.getEncoder().encodeToString(getProductImage());
    }
    return "";
  }


  public Product() {

  }
  public Product(int id, String name, String description, BigDecimal price, int categoryId, int stock) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.categoryId = categoryId;
    this.stock = stock;
  }

  public Product(String name, String description, BigDecimal price, int categoryId, int stock) {
    this(0, name, description, price, categoryId, stock);
  }

  // Getters and Setters
  // ...
}

