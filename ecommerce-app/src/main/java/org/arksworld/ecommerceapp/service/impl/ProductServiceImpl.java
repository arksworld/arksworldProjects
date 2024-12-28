package org.arksworld.ecommerceapp.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.arksworld.ecommerceapp.dao.ProductDao;
import org.arksworld.ecommerceapp.entity.Product;
import org.arksworld.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Override
  public void createProduct(Product product) {
    productDao.createProduct(product);
  }

  @Override
  public void updateProduct(Product product) {
    productDao.updateProduct(product);
  }

  @Override
  public void deleteProductById(int productId) {
    productDao.deleteProductById(productId);
  }

  @Override
  public Product getProductById(int productId) {
    return productDao.getProductById(productId);
  }

  @Override
  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }

  public List<Product> getProductsForUser(String category, BigDecimal minPrice, BigDecimal maxPrice,
                                          int page, int size) {
    int offset = (page - 1) * size;
    return productDao.getFilteredProducts(category, minPrice, maxPrice, offset, size);
  }

}
