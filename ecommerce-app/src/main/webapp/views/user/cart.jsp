<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="content">
        <h2>Your Shopping Cart</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <logic:iterate name="cartentries" id="item">
                    <tr>
                        <td><bean:write name="item" property="name" /></td>
                        <td><bean:write name="item" property="price" /></td>
                        <td>
                            <html:form action="/updateCart.do">
                                <html:hidden property="productId" value="${item.productId}" />
                                <html:text property="quantity" value="${item.quantity}" />
                                <html:submit value="Update" />
                            </html:form>
                        </td>
                        <td><bean:write name="item" property="totalPrice" /></td>
                        <td>
                            <html:link action="/removeFromCart.do?productId=${item.productId}">Remove</html:link>
                            <html:link action="/viewCheckout.do" styleClass="btn btn-primary">Checkout</html:link>
                        </td>
                    </tr>
                </logic:iterate>
            </tbody>
        </table>
        <a href="browseProducts.do">Continue Shopping</a>
    </div>
    <jsp:include page="../common/footer.jsp" />
</body>
</html>