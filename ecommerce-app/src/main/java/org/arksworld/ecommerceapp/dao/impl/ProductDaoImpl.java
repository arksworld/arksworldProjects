package org.arksworld.ecommerceapp.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.arksworld.ecommerceapp.dao.ProductDao;
import org.arksworld.ecommerceapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void createProduct(Product product) {
    String sql =
        "Insert into Products(id, name, description, price, category_id, stock, product_image, image_url) values(?,?,?,?,?,?,?,?)";
    jdbcTemplate.update(sql, product.getId(), product.getName(), product.getDescription(),
        product.getPrice(), product.getCategoryId(), product.getStock(), product.getProductImage(), product.getImageUrl());
  }

  @Override
  public void updateProduct(Product product) {
    String sql =
        "Update Products set name=?, description=?, price=?, category_id=?, stock=?,  image_url=? where id=?";
    jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(),
        product.getCategoryId(), product.getStock(),  product.getImageUrl(), product.getId());
  }

  @Override
  public void deleteProductById(int productId) {
    String sql = "Delete from Products where id=?";
    jdbcTemplate.update(sql, productId);
  }

  @Override
  public Product getProductById(int productId) {
    String sql = "Select * from Products where id=?";
    return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), productId);
  }

  @Override
  public List<Product> getAllProducts() {
    String sql = "Select * from Products";
    return jdbcTemplate.query(sql, new ProductRowMapper());
  }

  @Override
  public List<Product> getFilteredProducts(String category, BigDecimal minPrice,
                                           BigDecimal maxPrice, int offset, int limit) {
    String sql = "SELECT * FROM products WHERE 1=1";
    List<Object> params = new ArrayList<>();

    if (category != null && !category.isEmpty()) {
      sql += " AND category_id = ?";
      params.add(Integer.parseInt(category));
    }
    if (minPrice != null) {
      sql += " AND price >= ?";
      params.add(minPrice);
    }
    if (maxPrice != null) {
      sql += " AND price <= ?";
      params.add(maxPrice);
    }
    sql += " LIMIT ? OFFSET ?";
    params.add(limit);
    params.add(offset);

    System.out.println("offset=" + offset + ", limit=" + limit);
    return jdbcTemplate.query(sql, new ProductRowMapper(), params.toArray());
  }


  private static class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
      Product product = new Product();
      product.setId(resultSet.getInt("id"));
      product.setName(resultSet.getString("name"));
      product.setDescription(resultSet.getString("description"));
      product.setPrice(resultSet.getBigDecimal("price"));
      product.setCategoryId(resultSet.getInt("category_id"));
      product.setStock(resultSet.getInt("stock"));
      product.setProductImage(resultSet.getBytes("product_image"));
      product.setImageUrl(resultSet.getString("image_url"));
      return product;
    }
  }
}


