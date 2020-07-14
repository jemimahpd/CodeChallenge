<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Support Service</title>
</head>
<body style="background-color: khaki;">
<script type="text/javascript" language="javascript">



function OnSubmitForm()
{
var custparam = document.getElementById("custParam").value;
console.log(custparam);
var myform=document.getElementById("myForm");
   var userid = document.getElementById("custValue").value;
   console.log(userid);
   if(custparam==1){
   		myform.action ="customerphone";
   }  else if(custparam==2){
	   document.getElementById("myForm").action="allcustomerphones";
   }
   return myform.action;
}
function getCustParam(){
	var selectvalue=document.getElementById("custParam").value;
	if(selectvalue==2)	
		document.getElementById("custValue").disabled=true;
	else
		document.getElementById("custValue").disabled=false;
}
</script>

<center>
 <H1>BankOnUs Coding Challenge3</H1><br>
<h2>Customer Support Application</h2>
<H3>This utility fetches phone number of customer(s)</H3><br>
<form id="myForm" class="form-inline" method="post" onsubmit="OnSubmitForm();">
<select name="custParam" id="custParam" onchange="getCustParam();" >
    <option value="1">Customer ID</option>
    <option value="2">All Customers</option>
  </select>
<input type="text" id="custValue" name="custValue" class="form-control" placeholder="Search customer.."><br><br>
<button type="submit" name="save" class="btn btn-primary" >Search</button>
<br><br>
</form>


<table border="1" style="${tableViewStyle}">
<tr style="background-color: ghostwhite;">
<th>Customer ID</th>
<th>Customer Name</th>
<th>Email</th>
<th>Contact Number</th>
<th>Status</th>
</tr>
<c:forEach items="${CustomerList}" var="CustomerPhone">
<tr>
<td><c:out value="${CustomerPhone.customerid}"/></td>
<td><c:out value="${CustomerPhone.firstname}"/></td>
<td><c:out value="${CustomerPhone.lastname}"/></td>
<td><c:out value="${CustomerPhone.phone}"/></td>
<td><c:out value="${CustomerPhone.status}"/></td>
 </tr> 
</c:forEach>-
</table>

</center>
</body>
</html>