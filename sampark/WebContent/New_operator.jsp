<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="${pageContext.servletContext.contextPath}/js/jquery-1.12.0.js"></script>
<style>
span {
    visibility: hidden;
}
#sub_cat
{
visibility: hidden;
}
</style>
<script>
function aja1()
{
var sevalue=document.getElementById("ch").value;
if(sevalue=="Operator")
{
	alert("hi");
   $.ajax({
	              type:"POST",
                  url: "${pageContext.request.contextPath}/result/ajaxtest.do",
                  success: function(data){
                	  alert("hi");
                	  alert(data);
                	  //$('#sub_cat').append(data);
//$("#sub_cat").css('visibility', 'visible');
          },
   error: function(e){
	                alert('Error: ' + e);
   }

  });
}
else
{
$("#sub_cat").css('visibility', 'hidden');
//$("#rev").css('visibility', 'hidden');
}
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<br>
<form:form method="POST" commandName="register">
   <table border="0" width="90%">
                <tr>
					<td>User Type: </td>
					<td><form:select path="authority" onchange="aja1()" id="ch" name="ch">
                        <form:option value="Operator">Operator</form:option>  
                <form:option selected="true" value="Reviewer">Reviewer</form:option>  
                        </form:select>
                   </td>
                   <td><form:select name="sub_cat" id="sub_cat" path="assigned_officer_id">
                       </form:select></td></tr> 
                    <tr>
					<td align="left" width="20%">User Name </td>
					<td align="left" width="40%"><form:input path="user_name" size="30"/></td>
					<td align="left"><form:errors path="user_name" cssClass="error"/></td>
				</tr>
				    <tr>
					<td align="left" width="20%">First Name </td>
					<td align="left" width="40%"><form:input path="fname" size="30"/></td>
					<td align="left"><form:errors path="fname" cssClass="error"/></td>
				</tr>
				    <tr>
					<td align="left" width="20%">Last Name </td>
					<td align="left" width="40%"><form:input path="lname" size="30"/></td>
					<td align="left"><form:errors path="lname" cssClass="error"/></td>
				</tr>
				<tr>
					<td align="left" width="20%">Contact </td>
					<td align="left" width="40%"><form:input path="contact" size="30"/></td>
					<td align="left"><form:errors path="contact" cssClass="error"/></td>
				</tr>
				<tr>
					<td align="left" width="20%">Email Id</td>
					<td align="left" width="40%"><form:input path="email" size="30"/></td>
					<td align="left"><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Add"/></td>
					<td></td>
				</tr>
</table>  
</form:form>
</center>
</body>
</html>