package org.arksworld.ecommerceapp.actions.products;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.arksworld.ecommerceapp.entity.Product;
import org.arksworld.ecommerceapp.enums.ProductCategory;
import org.arksworld.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class BrowseProductsAction extends Action {

  @Autowired
  private  ProductService productService;

  public  BrowseProductsAction() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }


  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) {

    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("isLoggedIn") == null || !(boolean) session.getAttribute("isLoggedIn")) {
      return mapping.findForward("login");
    }

    String category = request.getParameter("categoryId");
    BigDecimal minPrice = request.getParameter("minPrice") != null  && !((String)request.getParameter("minPrice")).isEmpty() ?
        new BigDecimal(request.getParameter("minPrice")) : null;
    BigDecimal maxPrice = request.getParameter("maxPrice") != null && !((String)request.getParameter("maxPrice")).isEmpty() ?
        new BigDecimal(request.getParameter("maxPrice")) : null;
    int page =
        request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
    int size = 10;

    List<Product> products =
        productService.getProductsForUser(category, minPrice, maxPrice, page, size);
    System.out.println("Products:" + products.size());
    request.setAttribute("categories", Arrays.asList(ProductCategory.values()));
    request.setAttribute("products", products);
    request.setAttribute("page", page);
    return mapping.findForward("success");
  }
}

