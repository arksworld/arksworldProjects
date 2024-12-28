<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
    <title>Browse Products</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="content">
        <h2>Browse Products</h2>
        <html:form action="/browseProducts.do" method="GET">
            <label>Category:</label>
            <html:select property="categoryId">
                <html:option value="">All</html:option>
                <html:optionsCollection name="categories" value="categoryId" label="name" />
            </html:select>
            <label>Price Range:</label>
            <html:text property="minPrice" /> to <html:text property="maxPrice" />
            <html:submit value="Filter" />
        </html:form>

        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>&nbsp;&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <logic:iterate name="products" id="product">
                    <div class="product-card">
                    <tr>
                        <td><bean:write name="product" property="name" /><br/>
                        <logic:empty name="product" property="imageUrl">
                           <img style="width:200px;height:100px;"
                                                                src="data:image/jpeg;base64,<bean:write name='product' property='imageBase64' />"
                                                                alt="<bean:write name='product' property='name' />" />
                        </logic:empty>
                        <logic:notEmpty name="product" property="imageUrl">
                         <img style="width:200px;height:100px;"
                                                                                        src="<bean:write name='product' property='imageUrl' />"
                                                                                        alt="<bean:write name='product' property='name' />" />
                        </logic:notEmpty>

                        </td>
                        <td><bean:write name="product" property="description" /></td>
                        <td><bean:write name="product" property="price" /></td>
                        <td>
                            <html:form action="/addToCart.do">
                            <html:hidden property="productId" value="${product.id}" />
                            <html:text property="quantity" value="1" size="3" />
                            <html:submit value="Add to Cart" />
                            </html:form>
                        </td>
                    </tr>
                    </div>
                </logic:iterate>
            </tbody>
        </table>

        <div class="pagination">
            <html:link action="/browseProducts.do?page=${page - 1}" style="margin-right: 10px;">Previous</html:link>
            <html:link action="/browseProducts.do?page=${page + 1}">Next</html:link>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" />
</body>
</html>
