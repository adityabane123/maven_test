<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</script>
</head>
<body>
<input type="button" value="Add" onclick="aja1()"/>
</body>
</html>