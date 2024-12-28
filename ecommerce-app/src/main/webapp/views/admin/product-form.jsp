<%@ page import = "java.util.Map, java.util.Enumeration" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
    <title>Product Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="content">
        <h2>${param.action == 'edit' ? 'Edit Product' : 'Add New Product'}</h2>
        <br /> <br />
        <html:errors/>

        <html:form action="/saveProducts.do" enctype="multipart/form-data">

            <input type="hidden" name="action" value="${param.action}" />
            <input type="hidden" name="id" value="${productForm.id}" />


            <label for="name">Name:</label>
            <html:text property="name" size="20" />

            <label for="description">Description:</label>
            <textarea name="description" id="description" required>${productForm.description}</textarea>

            <label for="price">Price:</label>
            <input type="text" name="price" id="price" value="${productForm.price}"  />

            <label for="categoryId">Category:</label>
            <select name="categoryId" id="categoryId" required>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}" ${product.categoryId == category.id ? 'selected' : ''}>${category.name}</option>
                </c:forEach>
            </select>

            <label for="stock">Stock:</label>
            <input type="number" name="stock" id="stock" value="${productForm.stock}" required />

            <!-- Image Upload -->
            <label>Product Image:</label>
            <html:file property="productImage" /><br />

            <button type="submit" class="btn">Save</button>
        </html:form>
    </div>
</body>
</html>
