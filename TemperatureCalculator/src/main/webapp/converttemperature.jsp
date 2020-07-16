<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>File upload Utility</title>
</head>
<body style="background-color: khaki;">
<script type="text/javascript" language="javascript">

function OnSubmitForm()
{
var degreeScale = document.getElementById("degreeScale").value;
console.log(degreeScale);
var myform=document.getElementById("myForm");
const Url = "http://q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=celsius&val=30"
$.ajax({
    type: "POST",
    contentType: "text/xml; charset=utf-8",
    datatype: "xml",
    url: Url,
    data: { property: "celsius", value : "30"} ,
    data: requestXML,
    beforeSend: function (XMLHttpRequest) {
        XMLHttpRequest.setRequestHeader("Accept", "application/xml, text/xml, */*");
        XMLHttpRequest.setRequestHeader("SOAPAction", "http://schemas.microsoft.com/xrm/2011/Contracts/Services/IOrganizationService/Execute");
    },
    success: function (data, textStatus, XmlHttpRequest) {
       alert($(XmlHttpRequest.responseText).find('b\\:value').text()); // check this in console.log
    },
    error: function (XMLHttpRequest, textStatus, errorThrown) {
        alert(errorThrown);
    }
});
}

</script>

<center>
 <H1>BankOnUs Coding Challenge2</H1><br>
 <H2>Temperature Convertor</H2>
<H3>This utility converts temperature from Celsius to Fahrenheit and vice versa.</H3><br>
${message}


<form id="myForm" class="form-inline" method="post" onsubmit="OnSubmitForm();">
<select name="degreeScale" id="degreeScale" onchange="getDegreeScale();" >
    <option value="1">Celsius</option>
    <option value="2">Fahrenheit</option>
  </select>
<input type="text" id="degreeVal" name="degreeVal" class="form-control" placeholder="Enter degree.."><br><br>
<button type="submit" name="convert" class="btn btn-primary" >Convert</button>
<br><br>
</form>      
	

</center>


</body>
</html>