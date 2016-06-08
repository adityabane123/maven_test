<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/angular.js"></script>
<!--  <script src="js/my.js"></script>-->
<script type="text/javascript">
/*var app=angular
.module("mymodule",[])
.controller("mycontroller",function($http,$scope){
      $http({
     method:"POST",
     data: { 'message' : 'heyyyyyyyy' },
     url:"${pageContext.request.contextPath}/result/angu.do"})
      .then(function(response){
    	  alert(response.data);
       $scope.employee=response.data;
          });
    });
*/

var app=angular
.module("mymodule",[])
.controller("mycontroller",function($http,$scope){
var data = 'name=Aditya';								
$http.post('${pageContext.request.contextPath}/result/angu.do', data )
.success(function(data, status, headers, config) {
	$scope.employee=data;
});
});


/*var app=angular
.module("mymodule",[])
.controller("mycontroller",function($scope){
	$scope.employee="Adityas";
})*/	
	
function myfun1(service_id)
{
	var mapForm = document.createElement("form");
    mapForm.target = "Map";
    mapForm.method = "POST"; // or "post" if appropriate
    mapForm.action = "http://localhost:8080/sampark/Viewserviceinfo.do";
    var mapInput = document.createElement("input");
    mapInput.type = "text";
    mapInput.name = "id";
    mapInput.value = service_id;
    mapForm.appendChild(mapInput);
    document.body.appendChild(mapForm);
    map = window.open("", "Map", "status=0,title=0,height=600,width=800,scrollbars=1");
if (map) {
    mapForm.submit();
    document.body.removeChild(mapForm);
} else {
    alert('You must allow popups for this map to work.');
}
/*alert(service_id);
window.open("http://localhost:8080/sampark/Viewserviceinfo.do");*/
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Service</title>
</head>
<body ng-app="mymodule">
<h1><c:out value="${sessionScope.username}"/></h1>
<table>
<tr>
                <th align="center">Service Name</th>
				<th align="center">Status</th>
				<th align="center">Service Info</th>
 				<th align="center">Show</th>
</tr>
<c:forEach var="listVar" items="${mylist}">
    <tr><td><c:out value="${listVar.service_name}"/></td>
    <td><c:out value="${listVar.status}"/></td>
    <td><c:out value="${listVar.submitted_date}"/></td>
    <td><input type="button" value="Show" id="sh" onclick="myfun1('${listVar.service_id}');"/></td>
    </tr>
</c:forEach>
</table>
<a href='<c:url value="http://localhost:8080/sampark/New_service.do" />'>Home</a>
<a href='<c:url value="http://localhost:8080/sampark/New_operator.do" />'>New Operator</a>
<a href='<c:url value="http://localhost:8080/sampark/All_operator.do" />'>All Operator</a>
      <!--<div>
         <label>Name:</label>
         <input type = "text" ng-model = "yourName" placeholder = "Enter a name here">
         <hr />
         
         <h1>Hello {{yourName}}!</h1>
      </div>-->
<div>
10+20={{10+20}}
<div ng-controller="mycontroller">
{{employee}}
</div>
</div>
</body>
</html>