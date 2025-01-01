
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">

<div class="header">
    <c:choose>
    <c:when test="${sessionScope.role == 'ADMIN'}">
        <html:link forward="adminDashboard"><h1>Ecommerce Application<h1></html:link>
    </c:when>
    <c:when test="${sessionScope.role == 'USER'}">
        <html:link action="/browseProducts.do"><h1>Ecommerce Application</h1></html:link>
     </c:when>
     <c:otherwise>
        <h1>Ecommerce Application</h1>
     </c:otherwise>
     </c:choose>
    <nav>
            <c:choose>
                <%-- Admin Navigation --%>
                <c:when test="${sessionScope.role == 'ADMIN'}">
                    <a href="${pageContext.request.contextPath}/views/admin/admin-dashboard.jsp">Admin Dashboard</a>
                    <a href="reports.jsp">Reports</a>
                    <html:link action="/logout.do">Logout</html:link>
                </c:when>
                <%-- User Navigation --%>
                <c:when test="${sessionScope.role == 'USER'}">
                    <html:link action="/browseProducts.do">Browse Products</html:link>
                    <html:link action="/viewCart.do">View Cart
                        <logic:present name="cartItemCount">${cartItemCount}</logic:present>
                    </html:link>
                    <html:link action="/orderHistory.do">Order History</html:link>
                    <html:link action="/logout.do">Logout</html:link>
                </c:when>
                <%-- Guest Navigation --%>
                <c:otherwise>
                    <html:link forward="login">Login</html:link>
                    <html:link forward="register">Register</html:link>
                </c:otherwise>
            </c:choose>
    </nav>
</div>
