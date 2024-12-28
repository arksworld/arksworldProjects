package org.arksworld.ecommerceapp.actionforms;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.PropertyMessageResources;
import org.apache.struts.validator.ValidatorForm;
import org.arksworld.ecommerceapp.enums.ProductCategory;

public class ProductActionForm extends ValidatorForm {

  private String action;
  private int id;
  private String name;
  private String description;
  private String price;
  private int categoryId;
  private int stock;
  private String imageUrl;
  private List<ProductCategory> categories;

  private String minPrice;
  private String maxPrice;
  private FormFile productImage;


  public List<ProductCategory> getCategories() {
    return categories;
  }

  public void setCategories(List<ProductCategory> categories) {
    this.categories = categories;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
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

  public String getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
  }

  public String getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(String minPrice) {
    this.minPrice = minPrice;
  }



  public FormFile getProductImage() {
    return productImage;
  }

  public void setProductImage(FormFile productImage) {
    this.productImage = productImage;
  }


  @Override
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    System.out.println("Inside validate method");
    ActionErrors errors = super.validate(mapping, request);
     return errors;
  }

  private void debug() {
    /*System.out.println("Got errors:" + errors);
    System.out.println("Locale:" + Locale.getDefault());
    System.out.println("Struts locale:" + request.getAttribute("org.apache.struts.action.LOCALE"));
    request.getSession().setAttribute("org.apache.struts.action.LOCALE", Locale.getDefault());
    if(request.getAttribute("org.apache.struts.action.MESSAGE") != null && request.getAttribute("org.apache.struts.action.MESSAGE") instanceof PropertyMessageResources) {
      PropertyMessageResources mr =
          (PropertyMessageResources) request.getAttribute("org.apache.struts.action.MESSAGE");
      System.out.println(mr.getMessage("error.price.required"));
    }
    Iterator errosIter =  errors.get();
    while(errosIter.hasNext()) {
      ActionMessage report = (ActionMessage) errosIter.next();
      System.out.println("report:" + report);


      if(report.isResource()) {
        System.out.println("Resource");
        System.out.println("key:" + report.getKey());
        if(report.getValues() != null) {
          for(Object value: report.getValues()) {
            System.out.println("value:" + value);
          }
        }

      } else {
        System.out.println("Not resource");
      }
    }*/
  }
}
