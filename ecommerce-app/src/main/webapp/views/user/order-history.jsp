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
    <h2>Order History</h2>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Total Amount</th>
            <th>Created At</th>
            <th>Actions</th>
        </tr>
        <logic:iterate name="orders" id="order">
            <tr>
                <td><bean:write name="order" property="orderId" /></td>
                <td><bean:write name="order" property="totalAmount" /></td>
                <td><bean:write name="order" property="orderDateTime" /></td>
                <td>
                    <html:link action="/viewOrderDetails.do?orderId=${order.orderId}">View Details</html:link>
                </td>
            </tr>
        </logic:iterate>
    </table>
    </div>
    4
    
   <jsp:include page="../common/footer.jsp" />
</body>
</html>
