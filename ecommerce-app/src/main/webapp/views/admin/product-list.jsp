<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>

    <div class="content">
        <h2>Product List</h2>
        <a href="${pageContext.request.contextPath}/views/admin/product-form.jsp?action=create" class="btn">Add New Product</a>
        <table border="1" cellpadding="10">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Stock</th>
                    <th>Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">

                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td><fmt:formatNumber value="${product.price}" type="currency" /></td>
                        <td>${product.categoryId}</td>
                        <td>${product.stock}</td>
                        <td><img style="height:100px;width:200px" src="data:image/jpeg;base64,${product.imageBase64}" alt="${product.name}" />
                        <td>
                            <a href="<c:url value='/products.do?action=edit&id=${product.id}'/>">Edit</a> |
                            <a href="<c:url value='/products.do?action=delete&id=${product.id}'/>" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


</body>
</html>
