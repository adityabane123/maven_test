<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Entry</title>
<style>
	.error
	{
		color:red;
	}
</style>
<script src="js/angular.js"></script> 
</head>
<body>

<h2>Voters Login</h2>
<form:form method="POST" commandName="login">
   <table border="0" width="90%">
    <tr>
					<td align="left" width="20%">User Name: </td>
					<td align="left" width="40%"><form:input path="user_name" size="30"/></td>
					<td align="left"><form:errors path="user_name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><form:password path="pass" size="30"/></td>
					<td><form:errors path="pass" cssClass="error"/></td>
				</tr>
				
				<tr>
					<td>Image#</td>
					<td>
						<div>
							<img id="captcha_id" name="imgCaptcha" src="captcha.jpg">
						</div>
					</td>


					<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
							<img src="images/refresh.png" />
					</a></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="captcha" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter above Image text#</td>
					<td><form:input path="captcha" /></td>
				</tr>
				
				
				<tr>
					<td class="error"><c:out value="${nousr}"/></td>
					<td align="center"><input type="submit" value="Login"/></td>
					<td></td>
				</tr>
</table>  
</form:form>
<div ng-app>
    <input type="text" ng-model="data.message" />
    <h1>{{ data.message }}</h1>
    </div>
</body>
</html>