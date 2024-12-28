package org.arksworld.ecommerceapp.service;

import java.math.BigDecimal;
import java.util.List;
import org.arksworld.ecommerceapp.entity.Product;

public interface ProductService {
  public void createProduct(Product product);
  public void updateProduct(Product product);
  public void deleteProductById(int productId);
  public Product getProductById(int productId);
  public List<Product> getAllProducts();
  public List<Product> getProductsForUser(String category, BigDecimal minPrice, BigDecimal maxPrice,
                                          int page, int size);
}
