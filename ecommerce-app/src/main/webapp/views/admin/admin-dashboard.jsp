<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />

    <div class="content">
        <h2>Admin Dashboard</h2>
        <ul>
            <li><a href="<c:url value='/products.do'/>">Manage Products</a></li>
            <li><a href="reports.jsp">View Reports</a></li>
        </ul>
    </div>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>
