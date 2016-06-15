<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

function validate_form() {
	window.close();
}

</script>
</head>
<body>
<div align="left">
   <table border="0" width="90%">
<tr>
<td>Department Name: </td>
<td><input type="text" id="department" size="30"  value="${dept_name}"/></td>
</tr>
<tr>
<td>Service Name: </td>
<td><input type="text" id="service" size="30"  value="${serv.service_name}"/></td>
</tr>
<tr> <td>  </td>
<td><a href="${serv.procedure_doc}">View</a></td></tr>
<tr><td></td><td></td></tr>
<tr><td></td><td></td></tr>
<tr><td></td><td></td></tr>
<tr><td></td><td>
<table id="myTableData">
<tr>
<th>Document</th>
<th>Mandatory</th>
</tr>
<c:forEach var="appl" items="${myserv}">
    <tr><td>${appl.key}</td><td>${appl.value}</td></tr>
</c:forEach>
</table>
</td></tr>
  <tr>
					<td>Eligibility </td>
					<td><input type="text" id="Eligibility" size="30" value="${eli}"/></td>
				</tr>
				<tr>
					<td>Fee </td>
					<td><input type="text" id="fee" size="30" value="${fee}"/></td>
				</tr>
				<tr>
					<td>Expected Delivery Date </td>
					<td><input type="text" id="edd" size="30" value="${edd}"/></td>
				</tr>
			     <tr>
					<td>Summary</td>
					<td><input type="text" id="sum" size="30" value="${sum}"/></td>
				</tr>
				<tr>	
					<td></td>
					<td><input type = "button" id="add_btn" onclick = "validate_form()" value = "Close"></td>
				</tr>
</table> 
</div> 
</body>
</html>