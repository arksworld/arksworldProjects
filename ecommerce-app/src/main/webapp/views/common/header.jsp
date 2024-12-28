
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
        <ul>
            <c:choose>
                <%-- Admin Navigation --%>
                <c:when test="${sessionScope.role == 'ADMIN'}">
                    <li><a href="${pageContext.request.contextPath}/views/admin/admin-dashboard.jsp">Admin Dashboard</a></li>
                    <li><a href="reports.jsp">Reports</a></li>
                    <li><html:link action="/logout.do">Logout</html:link></li>
                </c:when>
                <%-- User Navigation --%>
                <c:when test="${sessionScope.role == 'USER'}">
                    <li><html:link action="/browseProducts.do">Browse Products</html:link></li>
                    <li><html:link action="/viewCart.do">View Cart</html:link></li>
                         <logic:present name="cartItemCount">
                            <span class="badge">${cartItemCount}</span>
                         </logic:present>
                    <li><html:link action="/orderHistory.do">Order History</html:link></li>
                    <li><html:link action="/logout.do">Logout</html:link></li>
                </c:when>
                <%-- Guest Navigation --%>
                <c:otherwise>
                <li><html:link forward="login">Login</html:link></li>
                <li><html:link forward="register">Register</html:link></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</div>
