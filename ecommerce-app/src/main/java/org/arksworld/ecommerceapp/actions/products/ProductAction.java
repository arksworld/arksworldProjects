package org.arksworld.ecommerceapp.actions.products;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.arksworld.ecommerceapp.actionforms.ProductActionForm;
import org.arksworld.ecommerceapp.entity.Product;
import org.arksworld.ecommerceapp.enums.ProductCategory;
import org.arksworld.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class ProductAction extends Action {

  @Autowired
  private ProductService productService;

  public ProductAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }


  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

    String action = request.getParameter("action");
    System.out.println("Action:" + action);
    try {
      if ("edit".equals(action)) {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(productId);
        request.setAttribute("product", product);
        ProductActionForm productActionForm = (ProductActionForm) form;
        System.out.println("Action from form:" + productActionForm.getAction());
        productActionForm.setId(productId);
        productActionForm.setName(product.getName());
        productActionForm.setDescription(product.getDescription());
        productActionForm.setPrice(product.getPrice().toString());
        productActionForm.setCategoryId(product.getCategoryId());
        productActionForm.setStock(product.getStock());
        productActionForm.setImageUrl(product.getImageUrl());
        productActionForm.setCategories(Arrays.asList(ProductCategory.values()));

      } else if("delete".equals(action)) {
        int productId = Integer.parseInt(request.getParameter("id"));
        productService.deleteProductById(productId);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return mapping.findForward("failure");
    }

    request.getSession().setAttribute("categories", ProductCategory.values());
    if ("edit".equals(action)) {
      return mapping.findForward("form");
    } else {
      request.getSession().setAttribute("products", productService.getAllProducts());
      return mapping.findForward("success");
    }
  }
}
