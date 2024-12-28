<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<body>
    <!-- Include the shared header -->
    <jsp:include page="common/header.jsp" />
    <h1>Welcome home!</h1>
    <a href="<c:url value='/logout.do' />">Logout</a>
    <jsp:include page="common/footer.jsp" />
</body>
</html>