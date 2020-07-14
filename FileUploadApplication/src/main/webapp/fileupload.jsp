<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>File upload Utility</title>
</head>
<body style="background-color: khaki;">
<center>
 <H1>BankOnUs Coding Challenge1</H1><br>
 <H2>File Upload Utility</H2>
<H3>This utility uploads your file to MySQL server after validation.</H3><br>
${message}
<table>
<td><b>Select a file to upload:  </b></td>
<td><form method="POST" action="/fileupload" enctype="multipart/form-data">
   <br> <br><input type="file" name="file" /><br/><br/>
    <input type="submit" value="Submit" />
</form></td></table>
       <br /><br/>
      
	

</center>


</body>
</html>