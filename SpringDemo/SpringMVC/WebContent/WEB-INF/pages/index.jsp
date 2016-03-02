<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index page</title>
</head>
<body>
	<form:form action="home.htm" method="post" commandName="user">
		<form:label path="Username" />
		<form:input path="username" />
		<br />
		<form:label path="Password" />
		<form:input path="password" />
		<form:button>Login</form:button>
	</form:form>
</body>
</html>