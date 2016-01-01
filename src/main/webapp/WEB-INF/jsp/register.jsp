<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${user == null}">
			<div align="center">
				<h1>Register Here</h1>
			</div>
			<form:form commandName="newUser">
				<table align="center">
					<tr>
						<td>First Name :</td>
						<td><form:input path="newUserFirstName" /></td>
						<td><form:errors path="newUserFirstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="newUserLastName" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input path="newUserEmail" /></td>
						<td><form:errors path="newUserEmail" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><form:password path="newUserPassword" /></td>
						<td><form:errors path="newUserPassword" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Confirm Password :</td>
						<td><form:password path="newUserConfirmPassword" /></td>
						<td><form:errors path="newUserConfirmPassword"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td>Mobile :</td>
						<td><form:input path="mobile" /></td>
						<td><form:errors path="mobile" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Register As :</td>
						<td><form:select path="role">
								<c:forEach var="authority" items="${authorities}">
									<option value="${authority}"><c:out
											value="${authority}" /></option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Register"></td>
					</tr>
				</table>
			</form:form>
			<input type="button" value="Cancel"
				onclick="location.href='/FitnessTracker/home.html'">
		</c:when>
		<c:otherwise>
			${user} is already logged in.
			Logout to register.
			<a href="/PlaceFinderServer/account.html">Go to Account >></a>
		</c:otherwise>
	</c:choose>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>