<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
    <title>Checkout</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="content">
    <h2>Order Details</h2>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
        <logic:iterate name="orderItems" id="item">
            <tr>
                <td><bean:write name="item" property="productName" /></td>
                <td><bean:write name="item" property="quantity" /></td>
                <td><bean:write name="item" property="price" /></td>
                <td><bean:write name="item" property="totalPrice" /></td>
            </tr>
        </logic:iterate>
    </table>
    </div>
   <jsp:include page="../common/footer.jsp" />
</body>
</html>
