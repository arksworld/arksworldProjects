<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
    <title>Order Summary</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
        <div class="content">
            <h2>Order Confirmed</h2>
            <p>Your order ID is <bean:write name="orderId" />.</p>
            <p>Thank you for shopping with us!</p>
            <html:link action="/browseProducts.do">Continue Shopping</html:link>
        </div>
    <jsp:include page="../common/footer.jsp" />
</body>
</html>
