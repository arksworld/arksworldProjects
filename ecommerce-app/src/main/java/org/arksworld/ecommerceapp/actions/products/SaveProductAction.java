package org.arksworld.ecommerceapp.actions.products;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.arksworld.ecommerceapp.actionforms.ProductActionForm;
import org.arksworld.ecommerceapp.actions.BaseAction;
import org.arksworld.ecommerceapp.entity.Product;
import org.arksworld.ecommerceapp.enums.ProductCategory;
import org.arksworld.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class SaveProductAction extends BaseAction {


  @Autowired
  private ProductService productService;

  public SaveProductAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }

  private static void mapProduct(Product product, HttpServletRequest request) {
    product.setName(request.getParameter("name"));
    product.setDescription(request.getParameter("description"));
    product.setPrice(new BigDecimal(request.getParameter("price")));
    product.setStock(Integer.parseInt(request.getParameter("stock")));
    product.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
  }

  private static void mapProductFromForm(Product product, ProductActionForm form) {
    product.setName(form.getName());
    product.setDescription(form.getDescription());
    product.setPrice(new BigDecimal(form.getPrice()));
    product.setStock(form.getStock());
    product.setCategoryId(form.getCategoryId());

    byte[] imageData = null;
    FormFile imageFile = form.getProductImage();
    if (imageFile != null && imageFile.getFileSize() > 0) {
      try {
        imageData = imageFile.getFileData();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    product.setProductImage(imageData);
  }

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

    String action = request.getParameter("action");
    System.out.println("Action:" + action);

    ProductActionForm productActionForm = (ProductActionForm) form;
    ActionErrors errors = new ActionErrors();
    // Perform custom validation
    if (new BigDecimal(productActionForm.getPrice()).compareTo(BigDecimal.ZERO) <= 0) {
      errors.add("price", new ActionMessage("error.price.positive"));
    }

    if (!errors.isEmpty()) {
      saveErrors(request, errors);
      return mapping.findForward("form");
    }
    try {
      if ("create".equals(action)) {
        Product product = new Product();
        mapProductFromForm(product, productActionForm);
        productService.createProduct(product);
      } else if ("edit".equals(action)) {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(productId);
        mapProductFromForm(product, productActionForm);
        productService.updateProduct(product);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return mapping.findForward("failure");
    }

    request.setAttribute("products", productService.getAllProducts());


    return mapping.findForward("success");
  }

}