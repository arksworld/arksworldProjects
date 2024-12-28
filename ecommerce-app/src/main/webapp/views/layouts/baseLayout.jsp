<html>
<head>
   <%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
    <title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div><tiles:insert name="header" /></div>
    <div><tiles:insert name="content" /></div>
    <div><tiles:insert name="footer" /></div>
</body>
</html>
