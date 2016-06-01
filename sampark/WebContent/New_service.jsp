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
            ul, li {list-style-type: none;}
            label{padding-left:20px}
            .main_body{
                /*background: linear-gradient(to top, #072C4E 0%, #0E3B64 50%, #124370 51%, #164C7D 78%, #1A5489 100%);*/
                background: #F1F1F1;
                border: 1px solid #dedede;
                border-radius: 4px;
                box-shadow: 0 2px 2px -1px rgba(0, 0, 0, 0.055);
                color: #000;
                display: block;
                margin:0 auto;
                margin-top: 3px;
                /*overflow: hidden;*/
                width: 70%;
                height : auto;
            }

            table{
                width : 75%;
                font-size: 1.2em;
            }
            th {
                text-align: center;
            }
            td{
                width : 50%;
            }
            table, tr, th, td {
                border: 0px solid black;
            }
            .heading{
                padding-left: 15%;
                /*text-align: center;*/
            }
            .input_field{
                padding-left: 5%;
                padding-right: 5%;
            }
            .input_box{
                width: 75%;
            }

            .button{
                /*background-color: #3E5365;*/
                background: linear-gradient(to top, #072C4E 0%, #0E3B64 50%, #124370 51%, #164C7D 78%, #1A5489 100%);
                border: none;
                color: white;
                padding: 5px 30px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
            .button:hover{
                color: black;
                background: #3E5365;
            }
            .footer{
                margin:0 auto;
                width: 70%;
                height : auto;
            }
            textarea {
                resize: none;
            }

        </style>
        <script src="${pageContext.servletContext.contextPath}/js/jquery-1.12.0.js"></script>
<script>

function addRow() {
    var doc1 = document.getElementById("App_Doc").value;
    if (doc1 != '')
    {
        document.getElementById("myTableData").style.visibility = "visible";
        var doc = document.getElementById("App_Doc");
        var man = $("input[name=mandatory]:checked").val();
        var table = document.getElementById("myTableData");
        var TableData = new Array();
        $('#myTableData tr').each(function (row, tr) {
            TableData[row] = {
                "docs": $(tr).find('td:eq(0)').text()
                , "man": $(tr).find('td:eq(1)').text()
            }
        });
        TableData.shift();  // first row is the table header - so remove
        $.each(TableData, function (key, value) {
            if (value.docs == doc.value)
            {
                alert("Document Already Exists");
                Break;
            }
        });
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        row.insertCell(0).innerHTML = doc.value;
        row.insertCell(1).innerHTML = man;
        row.insertCell(2).innerHTML = '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
    }
    document.getElementById("App_Doc").value = '';
}

function deleteRow(obj) {

    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("myTableData");
    var rowCount = table.rows.length;
    table.deleteRow(index);
    if (rowcount == '1')
    {
        document.getElementById("myTableData").style.visibility = "hidden";
    }

}
function addTable() {

    var myTableDiv = document.getElementById("myDynamicTable");

    var table = document.createElement('TABLE');
    table.border = '1';

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var i = 0; i < 3; i++) {
        var tr = document.createElement('TR');
        tableBody.appendChild(tr);

        for (var j = 0; j < 4; j++) {
            var td = document.createElement('TD');
            td.width = '75';
            td.appendChild(document.createTextNode("Cell " + i + "," + j));
            tr.appendChild(td);
        }
    }
    myTableDiv.appendChild(table);
}

</script>
</head>
<body>

<h2>Add Service</h2>
<form  method="post"  name="addService">
                <table cellpadding="5" id="addService">
                    <tr>
                        <th style="text-align: center;" colspan="2">Add service<hr></th>
                    </tr>
                    <tr id="tr_input_language">
                        <td class = "heading">Language	:</td>
                        <td class = "input_field">
                            <select id="input_languages" style="width: 75%;">
                            </select>
                        </td>
                    </tr>
				<tr>
					<td class = "heading">Select Department: </td>
					<td class = "input_field"><select id="ch" name="ch">    
                     
</select></td>
				</tr>
                    <tr id="tr_service_name">
                        <td class = "heading">Service Name	:</td>
                        <td class = "input_field">
                            <input type="text" name="Service_name" id="Service_name" class = "input_box">
                        </td>
                    </tr>
                    <tr id="tr_cat_name"> 
                            <!--<td><b>Category</b></td>
                                    <td>
                                            <input type="text" name="category_name" id="category_name"> 
                                    </td>-->
                    </tr>
                    <tr id="tr_uploadfile">
                        <td class = "heading">How to Apply :</td>
                        <td class = "input_field"><input type="file" name="file" id="file"/></td>
                    </tr>
                    <tr id="tr_common_Documents">
                        <td class = "heading" style = "vertical-align: text-top;">Documents :</td>
                        <td id="commondocuments" class = "input_field"></td>
                    </tr>
                    <tr>
                        <td class = "heading">
                            <b>Other Required Document Info :</b>
                        </td>
                    </tr>
                            <tr>
                                <td class = "heading">Applicable document :</td>
                                <td class = "input_field">
                                    <input class = "input_box" type="text" name="App_Doc" id="App_Doc">
                                </td>
                            </tr>
                            <tr>
                                <td class = "heading"> Mandatory :</td>
                                <td id="rbtn" class = "input_field">Yes
                                    <input type="radio" id="yes" name="mandatory" value="Yes" checked>No
                                    <input type="radio" id="No" name="mandatory" value="No">
                                    <input id="myiddd" type = "button" onclick = "addRow();" value = "Add">
                                </td>		
                    <tr id="result_tr" style="display: none;">
                        <td></td>
                        <td><b>Application Documents :</b></td>
                        <td ><label style="margin-left:15px;">Mandatory</label></td>
                    </tr>
                    <tr>
                    <td>
                    <table style="visibility:hidden;" id="myTableData"  border="1" cellpadding="4">
                        <tr>        
                            <td style="padding-left: 15%; width : 55%;">Document</td>
                            <td style="padding-left: 5%; width : 25%;">Mandatory</td>
                            <td style="padding-left: 0%; width : 25%;">Action</td>
                        </tr>
                    </table>
                    </td>
                    </tr>
                        <tr>
                            <td class = "heading" style = "vertical-align: text-top;">Summary	:</td>
                            <td class = "input_field">
                                <textarea rows="4" name="Summary" id="Summary" class = "input_box"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class = "heading" style = "vertical-align: text-top;">Eligibility	:</td>
                            <td class = "input_field">
                                <textarea rows="4" cols="50" name="Eligibility" id="Eligibility" class = "input_box"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class = "heading">Fee	:</td>
                            <td class = "input_field">
                                <textarea rows="4" cols="50" name="Fee" id="Fee" class = "input_box"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class = "heading">Turnaround Time	:</td>
                            <td class = "input_field">
                                <textarea rows="4" cols="50" name="Del_Date" id="Del_Date" class = "input_box"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class = "heading">Contact Details	:</td>
                            <td class = "input_field">
                                <textarea rows="4" cols="50" name="contact" id="contact" class = "input_box"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center;">
                                <hr><input type = "button" id="add_btn" onclick = "validate_form()" value = "Submit" class = "button">
                            </td>
                        </tr>
                        
                   
                    <!--<tr>
                            <td colspan="2" style="text-align: center;">
                                    <hr><input type = "button" class = "button" id="change_btn" value = "Update" onclick='validate_form()'>				
                                    <input type = "button" class = "button" id="reset_btn" value = "Reset" onclick='reset_form()'>
                                    <input type = "button" class = "button" id="cancel_btn" value = "Cancel" onclick='cancel_form()'>
                            </td>
                    </tr>-->
                </table>
            </form>
<script>
                $(window).load(function () {
                    //clearall();
                    loadDocs();
                    loadDepartments();
                    loadlang();

                });

                function clearall()
                {
                    $('input:text').val('');
                    $("#result_tr").hide();
                    $("input:checkbox").attr('checked', false);
                    $('#file').val('');
                    $('#Summary').val('');
                    $('#Eligibility').val('');
                    $('#Department_id').val('');
                    $('#Service_name').val('')
                }
                

                function loadlang()
                {
                    $.ajax({
      	              type:"POST",
                        url: "${pageContext.request.contextPath}/result/lang.do",
                        success: function(data){
                        	$("#input_languages").html(data);
                },
         error: function(e){
      	                alert('Error: ' + e);
         }

        });

        }


                function loadDepartments()
                {
                	$.ajax({
        	              type:"POST",
                          url: "${pageContext.request.contextPath}/result/depart.do",
                          success: function(data){
                        	  $("#ch").html(data);
                }
                	});
                	}




                function loadDocs() {
                    var select = document.getElementById("commondocuments");
                        $.ajax({
          	              type:"POST",
                            url: "${pageContext.request.contextPath}/result/common.do",
                            success: function(data){
                        var options = data.split(",");

                        var i;
                        for (i = 0; i < options.length; i++) {
                            if (options[i]) {
                                var opt = options[i];
                                li = document.createElement('li');
                                var newLabel = document.createElement("label");
                                newLabel.appendChild(document.createTextNode(opt));
                                var newLabel1 = document.createElement("label");
                                newLabel1.appendChild(document.createTextNode("             "));
                                var newCheckBox = document.createElement('input');
                                newCheckBox.type = 'checkbox';
                                newCheckBox.id = 'checkbox' + i; // need unique Ids!
                                newCheckBox.value = (opt);

                                li.appendChild(newCheckBox);
                                li.appendChild(newLabel);
                                select.appendChild(li);


                            }
                        }
                            }
                            });   
                    
                }





                function validate_form() {
                    var TCode = document.getElementById('Service_name').value;
                    if (document.getElementById("input_languages").selectedIndex == 0)
                    {
                        alert("Please Select Input Language");
                        $("#input_languages").focus();
                        return false;
                    }
                    if (document.getElementById("Department_id").selectedIndex == 0)
                    {
                        alert("Please Select Department");
                        $("#input_languages").focus();
                        return false;
                    }
                    else if ($("#Service_name").val().trim() == "" || $("#App_Doc").val().trim() == undefined) {
                        alert("Please Enter Service name");
                        $("#Service_name").focus();
                    }

                    else if ($("#Eligibility").val().trim() == "" || $("#Eligibility").val().trim() == undefined) {
                        alert("Please Enter Eligibility criteria");
                        $("#Eligibility").focus();
                    }
                    else if ($("#Fee").val().trim() == "" || $("#Fee").val().trim() == undefined) {
                        alert("Please Enter Required Fee");
                        $("#Fee").focus();
                    }
                    else if ($("#Del_Date").val().trim() == "" || $("#Del_Date").val().trim() == undefined) {
                        alert("Please Enter Expected Delivery Date");
                        $("#Del_Date").focus();
                    }
                    else if ($("#Summary").val().trim() == "" || $("#Summary").val().trim() == undefined) {
                        alert("Provide short description of service ");
                        $("#Summary").focus();
                    }
                    else if ($("#contact").val().trim() == "" || $("#contact").val().trim() == undefined) {
                        alert("Provide Contact Details ");
                        $("#contact").focus();
                    }
                     else
                            {
                                addService();
                            }

                }


                function addService() {
            //alert("in add service");
                    var TableData = new Array();
                    var x = "\n<document>\n";
                    var y = "";
                    $('#myTableData tr').each(function (row, tr) {
                        TableData[row] = {
                            "docs": $(tr).find('td:eq(0)').text()
                            , "man": $(tr).find('td:eq(1)').text()
                        }
                    });
                    TableData.shift();  // first row is the table header - so remove
                    $.each(TableData, function (key, value) {
                        var str=value.docs;
                        str=str.replace(/&/g, '&amp;');
                        str=str.replace(/"/g, '&quot;');
                        str=str.replace(/'/g, '&apos;');
                        str=str.replace(/</g, '&lt;');
                        str=str.replace(/>/g, '&gt;');
                        y += "\n<document_info>\n";
                        y += "\n  <applicable_document>\n   ";
                        y += str;
                        y += "\n  </applicable_document>\n";
                        y += "\n  <mandatory>\n   ";
                        y += value.man;
                        y += "\n  </mandatory>\n";
                        y += "\n</document_info>\n";
                    });
                    x += y;
                    var dc = "";
                    if ($("#commondocuments input:checked").each(function (i) {

                        dc += "\n<document_info>\n";
                        dc += "\n  <applicable_document>\n   ";
                        dc += $(this).val();
                        dc += "\n  </applicable_document>\n";
                        dc += "\n  <mandatory>\n   ";
                        dc += "";
                        dc += "\n  </mandatory>\n";
                        dc += "\n</document_info>\n";
                    }))
                        ;
                    x += dc;


                    var doc = document.implementation.createDocument("", "", null);
                    var serv = doc.createElement("service");
                        $serv_name=$("#Service_name").val();
                        $serv_name=$serv_name.replace(/&/g, '&amp;');
                        $serv_name=$serv_name.replace(/"/g, '&quot;');
                        $serv_name=$serv_name.replace(/'/g, '&apos;');
                        $serv_name=$serv_name.replace(/</g, '&lt;');
                        $serv_name=$serv_name.replace(/>/g, '&gt;');
                    serv.setAttribute("name",$serv_name);
                    doc.appendChild(serv);
                    var xmlString = (new XMLSerializer()).serializeToString(doc);


                    var dep = document.implementation.createDocument("", "", null);
                    var dept = dep.createElement("Department");
            //dept .setAttribute("name",  $("#Department_name").val());
                    dept.setAttribute("name", $('#Department_id :selected').val());
                    dep.appendChild(dept);
                    var department = (new XMLSerializer()).serializeToString(dep);
                    var e = document.getElementById("Department_id");
                    var deptno = e.options[e.selectedIndex].value;
                    var ssname = document.getElementById("Service_name").value;
                    var contact = document.getElementById("contact").value;
                        /*contact=contact.replace('&', '&amp;');
                        contact=contact.replace('"', '&quot;');
                        contact=contact.replace("'", '&apos;');
                        contact=contact.replace('<', '&lt;');
                        contact=contact.replace('>', '&gt;');*/

            //alert(deptno);

                    var cat = document.implementation.createDocument("", "", null);
                    var categ = cat.createElement("category");
                    categ.setAttribute("name", $("#category_name").val());
                    cat.appendChild(categ);
                    var Category = (new XMLSerializer()).serializeToString(cat);

                    Category = Category.replace("/>", ">");
                    department = department.replace("/>", ">");
                    xmlString = xmlString.replace("/>", ">");

                    var e = document.getElementById("input_languages");
                    var lng = e.options[e.selectedIndex].text;
            //alert(lng);
                    var xml = "\n";
                    xml += department;
                    xml += "\n";
                    xml += xmlString;
                    xml += "\n";
                    xml += Category;
                    x += "\n</document>\n";
                    xml += x;
                    xml += " \n<eligibility>\n   ";
                         var eli=$("#Eligibility").val();
                        eli=eli.replace(/&/g, '&amp;');
                        eli=eli.replace(/"/g, '&quot;');
                        eli=eli.replace(/'/g, '&apos;');
                        eli=eli.replace(/</g, '&lt;');
                        eli=eli.replace(/>/g, '&gt;');
                    xml += eli;
                    xml += "\n </eligibility>\n";

                    xml += " <fee>\n   ";
                        var fea=$("#Fee").val();
                        fea=fea.replace(/&/g, '&amp;');
                        fea=fea.replace(/"/g, '&quot;');
                        fea=fea.replace(/'/g, '&apos;');
                        fea=fea.replace(/</g, '&lt;');
                        fea=fea.replace(/>/g, '&gt;');
                    xml += fea;
                    xml += " \n</fee>\n";

                    xml += " <Summary>\n   ";
                        var sum=$("#Summary").val();
                        sum=sum.replace(/&/g, '&amp;');
                        sum=sum.replace(/"/g, '&quot;');
                        sum=sum.replace(/'/g, '&apos;');
                        sum=sum.replace(/</g, '&lt;');
                        sum=sum.replace(/>/g, '&gt;');
                    xml += sum;
                    xml += " \n</Summary>\n";

                    xml += " <language>\n   ";
                    xml += lng;
                    xml += " \n</language>\n";

                    xml += " <expected_delivery_date>\n   ";
                    var tt=$("#Del_Date").val();
                      tt=tt.replace(/&/g, '&amp;');
                        tt=tt.replace(/"/g, '&quot;');
                        tt=tt.replace(/'/g, '&apos;');
                        tt=tt.replace(/</g, '&lt;');
                        tt=tt.replace(/>/g, '&gt;');
                    xml += tt;
                    xml += " \n</expected_delivery_date>\n";
                    xml += " \n</category>\n";
                    xml += " \n</service>\n";
                    xml += " \n</Department>\n";

                    var service_name_serv = $("#Service_name").val();

                    $.post("${pageContext.request.contextPath}/result/Newserv.do", {xml: xml, service_name_serv: service_name_serv, deptno: deptno, contact: contact}, function (data, status) {

                        if (data.search("true") != -1) {
                            alert("Service Created Successfully");
                            var init = data.indexOf("[");
                            var fin = data.indexOf("]");
                            //var ser_id_post = data.substr(init + 1, fin - init - 1);
                            //file_data(ser_id_post);

                        }
                        else
                        {
                            alert("Try againn");
                        }
                    });
                    xml = "";
                }
                function bytesToSize(bytes) {
                    var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
                    if (bytes == 0)
                        return 'n/a';
                    var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
                    if (i == 0)
                        return bytes + ' ' + sizes[i];
                    return (bytes / Math.pow(1024, i)).toFixed(1) + ' ' + sizes[i];
                }

                
                function file_data(ser_id_post) {
                    if (document.getElementById("file").value != "") {

                        var file_data = $('#file').prop('files')[0];
                        var form_data = new FormData();
                        form_data.append('file', file_data);
                        form_data.append('ser_id_post', ser_id_post);

                        var sizeinbytes = document.getElementById('file').files[0].size;
                        if (sizeinbytes < 10485760) {


                            var hr_size = bytesToSize(sizeinbytes);


                            $.ajax({
                                url: '../dao/upload.php',
                                dataType: 'text',
                                cache: false,
                                contentType: false,
                                processData: false,
                                data: form_data,
                                type: 'post',
                                success: function (php_script_response) {
                                    if (php_script_response.search("true") != -1) {

                                        $('input:text').val('');
                                        $("#result_tr").hide();
                                        $("input:checkbox").attr('checked', false);
                                        $('#file').val('');
                                        $('#Summary').val('');
                                        alert("Service Info Added");
                                        location.reload();
                                    }
                                    else {

                                        $.post("../dao/removeservice.php", {ser_id_post: ser_id_post}, function (data, status) {

                                        });
                                        alert("file uploading failed");
                                        $('#file').val('');
                                        xml = "";
                                        x = "\n<document>\n";
                                    }

                                }
                            });
                        }
                        else {
                            $.post("../dao/removeservice.php", {ser_id_post: ser_id_post}, function (data, status) {

                            });
                            alert("file must be less than 10 MB");
                            $('#file').val('');
                            xml = "";
                            x = "\n<document>\n";
                        }
                    }
                    else {
                        $('input:text').val('');
                        $("#result_tr").hide();
                        $('#file').val('');
                        $('#Summary').val('');
                        $("input:checkbox").attr('checked', false);
                        alert("Service Info Added");
                        location.reload();

                    }
                }
            </script>
</body>
</html>