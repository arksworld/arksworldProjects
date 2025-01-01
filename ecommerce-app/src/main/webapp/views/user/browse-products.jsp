<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <title>Browse Products</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
    <div class="menu">
        <html:link action="/browseProducts.do?categoryId=1001">Phones</html:link>
        <html:link action="/browseProducts.do?categoryId=1002">Books</html:link>
    </div>
    <div class="content">
        <h2>Browse Products</h2>
        <div class="products">
            <logic:iterate name="products" id="product">
                <div class="product-card">
                    <logic:empty name="product" property="imageUrl">
                        <img src="data:image/jpeg;base64,<bean:write name='product' property='imageBase64' />"
                                               alt="<bean:write name='product' property='name' />" />
                    </logic:empty>

                    <logic:notEmpty name="product" property="imageUrl">
                        <logic:equal name="product" property="categoryId" value="1001">
                            <img src="https://images.freeimages.com/image/previews/eae/tech-call-phone-png-5692201.png"
                                  alt="<bean:write name='product' property='name' />" />
                        </logic:equal>
                        <logic:equal name="product" property="categoryId" value="1002">
                             <img src="https://www.scottishbooktrust.com/uploads/store/mediaupload/9085/image/xl_limit-picture-108539_1920.jpg"
                                    alt="<bean:write name='product' property='name' />" />
                        </logic:equal>

                    </logic:notEmpty>
                    <h3><bean:write name="product" property="name" /></h3>
                    <p><bean:write name="product" property="description" /></p>
                    <p>Price:$<bean:write name="product" property="price" /></p>
                    <html:form action="/addToCart.do">
                        <html:hidden property="productId" value="${product.id}" />
                        <html:text property="quantity" value="1" size="3" />
                        <html:submit value="Add to Cart" />
                    </html:form>
                </div>
            </logic:iterate>
        </div>
    </div>
    <div class="footer">© 2024 E-Commerce App</div>
</body>
</html>
