<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div style="padding:16px;background-color : GreenYellow" >
		<h3><a href="/PlaceFinderServer/home.html"> Go to home  </a></h3>
		<h1>Management Console</h1>
		<c:if test="${user != null}">
			<div align="right">
				<h3>
					Welcome ${user}!
					<br>
					<a href="j_spring_security_logout">Logout</a>
				</h3>
			</div>
		</c:if>
	</div>
	<br><br><br>
</body>
</html>