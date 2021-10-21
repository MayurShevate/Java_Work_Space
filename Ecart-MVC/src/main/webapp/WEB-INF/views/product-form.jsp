<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.center {
	margin-left: auto;
	margin-right: auto;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="background-color: #d2ff4d" align="center">
		<h2>Product Form</h2>
	</div>
	<hr />

	<jsp:include page="/menu.jsp" />
	<hr />
	`
	<form:form action="./saveProduct" autocomplete="off">
		<table border="1"  align="center" style="background-color: #92A8D1; ">
			<tbody>
				<tr>

					<td>Select Category:</td>
					<td><select name="category.categoryId">
							<option value="2">Ladies Wears</option>
							<option value="3">Mens Wear</option>
							<option value="4">Kids Wear</option>
							<option value="5">Furnitures</option>
							<option value="6">Home Appliances</option>
							<option value="12">Mobiles</option>
					</select></td>
				</tr>
				<tr>
					<td>Select Brand:</td>
					<td><select name="brand.brandId">
							<option value="1">HP</option>
							<option value="2">Samsung</option>
							<option value="3">Apple</option>
							<option value="4">Sony</option>

					</select></td>
				</tr>

				<tr>
					<td>ID:</td>
					<td><input type="text" name="productId"></td>
				</tr>
				<tr>
					<td>Name: </td><td><input type="text" name="productName">
					</td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="price"></td>

				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>Image Path:</td>
					<td><input type="text" name="imagePath"></td>

				</tr>

				<tr>
					<td>Quantity:</td>
					<td><input type="text" name="quantity"></td>

				</tr>

				<tr>
					<td>keywords:</td>
					<td><input type="text" name="keywords"></td>

				</tr>
			
			</tbody>
			
		</table></br>
		<div align="center"><input type="submit" value="Add Product" /></div>


	</form:form>

</body>
</html>