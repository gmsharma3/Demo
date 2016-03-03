<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
</head>
<body>
<form:form method="POST" modelAttribute="book" action="addNewBook.htm">
	<table>
		<tr>
			<td>Book Id</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>Book Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Book Price</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td>Publisher Id</td>
			<td><form:input path="publisher.id" /></td>
		</tr>
		<tr>
			<td>Publisher Name</td>
			<td><form:input path="publisher.name" /></td>
		</tr>
		<tr>
			<td><form:button>Submit</form:button></td>
			<td></td>
		</tr>
	</table>
</form:form>
</body>
</html>