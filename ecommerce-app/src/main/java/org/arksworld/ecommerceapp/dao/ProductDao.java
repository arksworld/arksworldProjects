package org.arksworld.ecommerceapp.dao;

import java.math.BigDecimal;
import java.util.List;
import org.arksworld.ecommerceapp.entity.Product;

public interface ProductDao {
  public void createProduct(Product product);

  public void updateProduct(Product product);

  public void deleteProductById(int productId);

  public Product getProductById(int productId);

  public List<Product> getAllProducts();

  List<Product> getFilteredProducts(String category, BigDecimal minPrice, BigDecimal maxPrice,
                                    int offset, int size);
}
