<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="header">E-Commerce App</div>
    <div class="content">
        <html:form action="/login.do">
            <h3>&nbsp;</h3>
            <label>Email</label>
            <input type="text" name="email" placeholder="Enter your email" required />

            <label>Password</label>
            <input type="password" name="password" placeholder="Enter your password" required />

            <button type="submit">Login</button>
            <div class="error">
                <bean:write name="errorMessage" />
            </div>
        </html:form>
    </div>
    <div class="footer">© 2024 E-Commerce App</div>
</body>
</html>
