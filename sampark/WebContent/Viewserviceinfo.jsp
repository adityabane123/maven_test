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

function addRow() {
    document.getElementById("myTableData").style.visibility = "visible";  
    var doc = document.getElementById("App_Doc");
    var man = document.getElementsByName("mandatory");
    for(var i = 0; i < man.length; i++){
        if(man[i].checked){
            man = man[i].value;
        }
    }
    var table = document.getElementById("myTableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    row.insertCell(0).innerHTML= doc.value;
    row.insertCell(1).innerHTML= man;
    row.insertCell(2).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
}

function deleteRow(obj) {
     
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("myTableData");
    table.deleteRow(index);
   
}
function addTable() {
     
    var myTableDiv = document.getElementById("myDynamicTable");
     
    var table = document.createElement('TABLE');
    table.border='1';
   
    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);
     
    for (var i=0; i<3; i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);
      
       for (var j=0; j<4; j++){
           var td = document.createElement('TD');
           td.width='75';
           td.appendChild(document.createTextNode("Cell " + i + "," + j));
           tr.appendChild(td);
       }
    }
    myTableDiv.appendChild(table);  
}

</script>
</head>
<body>
<div align="left">
<form method="POST" action="addservice.do">
   <table border="0" width="90%">
				<tr>
					<td>Select Department: </td>
					<td><select id="depa">
					<c:forEach items="${deptnames}" var="entry">
    <option value = "${entry.key}">${entry.value}</option>
    </c:forEach>
</select></td>
</tr>
<tr>
<td>Service Name: </td>
<td><input type="text" id="service" size="30"  value="${serv.service_name}"/></td>
</tr>
<tr> <td>  </td>
<td><a href="file:///F:\Associateship Election Form.pdf">View</a></td></tr>
<tr>
<td>Select Documents: </td>
<td><input type="checkbox" id="doc" value="Adhar Card"/>Adhar Card
<input type="checkbox" id="doc" value="Pan Card"/>Pan Card
<input type="checkbox" id="doc" value="Driver License"/>Driver License</td>
</tr>
<tr><td></td><td></td></tr>
<tr><td></td><td></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Applicable document :</td><td><input type="text" name="App_Doc" id="App_Doc"></td></tr>
				<tr><td> Mandatory :</td><td> Yes <input type="radio" id="yes" name="mandatory" value="Yes" checked> No  <input type="radio" id="No" name="mandatory" value="No" ></td></tr>
<tr><td><input type = "button" onclick = "addRow();" value = "Add"></td></tr>
<tr><td></td><td>
<table id="myTableData">
<tr>
<th>Document</th>
<th>Mandatory</th>
<th>Action</th>
</tr>
<c:forEach var="appl" items="${myserv}">
    <tr><td>${appl.key}</td><td>${appl.value}</td><td><input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)"></td></tr>
</c:forEach>
</table>
</td></tr>
<tr>
					<td>Eligibility </td>
					<td><input type="text" id="Eligibility" size="30" value="${serv.eligibility}"/></td>
				</tr>
				<tr>
					<td>Fee </td>
					<td><input type="text" id="fee" size="30" value="${serv.fee}"/></td>
				</tr>
				<tr>	
					<td></td>
					<td><input type = "button" id="add_btn" onclick = "validate_form()" value = "Submit"></td>
				</tr>
</table> 
</form>
</div> 
</body>
</html>