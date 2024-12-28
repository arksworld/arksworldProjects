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
    <!-- Display Validation Errors -->
    <html:errors />
    <html:form action="/checkout.do">
        <fieldset>
            <legend>Billing Details</legend>
            <label>Name:</label>
            <html:text property="name" /><br />
            <label>Address:</label>
            <html:textarea property="address" /><br />
            <label>Contact:</label>
            <html:text property="contact" /><br />
        </fieldset>

        <h3>Cart Summary</h3>
        <table border="1">
            <tr><th>Product</th><th>Quantity</th><th>Total</th></tr>
            <logic:iterate name="cartentries" id="item">
                <tr>
                    <td><bean:write name="item" property="name" /></td>
                    <td><bean:write name="item" property="quantity" /></td>
                    <td><bean:write name="item" property="totalPrice" /></td>
                </tr>
            </logic:iterate>
        </table>

        <html:submit value="Place Order" />
    </html:form>
    </div>
   <jsp:include page="../common/footer.jsp" />
</body>
</html>
