<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.username.focus();'>
	<jsp:include page="header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${user == null}">
			<div align="center">
				<h1>Login Here</h1>
			</div>
			<c:if test="${not empty error}">
				<div class="errorblock">
					Your login was unsuccessful. <br /> Caused:
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
				</div>
			</c:if>

			<form action="j_spring_security_check" name="f" method="post">
				<table>
					<tr>
						<td>User:</td>
						<td><input type="text" name="username" value=""></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="Submit"
							value="Submit"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="reset" name="reset"></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			${user} is already logged in.
			Logout to login with different credentials.
			<a href="/PlaceFinderServer/account.html">Go to Account >></a>
		</c:otherwise>
	</c:choose>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>