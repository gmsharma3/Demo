<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Books</title>
<style type="text/css">
tr {
	border: 1px solid black;
}

td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Books list</h1>
	<table>
		<tr>
			<td>Book id</td>
			<td>Book name</td>
			<td>Book price</td>
			<td>publisher id</td>
			<td>publisher name</td>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.publisher.id}</td>
				<td>${book.publisher.name}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="addBook.htm">Add New Book</a>
</body>
</html>