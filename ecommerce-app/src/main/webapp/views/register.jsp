<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<body>
    <!-- Include the shared header -->
    <jsp:include page="common/header.jsp" />
    <h1>User Registration</h1>
    <form action="<c:url value='/register.do'/>" method="POST">
        <label>Username:</label><input type="text" name="username" required/><br/>
        <label>Email:</label><input type="email" name="email" required/><br/>
        <label>Password:</label><input type="password" name="password" required/><br/>
        <input type="submit" value="Register"/>
    </form>
    <p>${message}</p>
 <jsp:include page="common/footer.jsp" />
</body>
</html>
