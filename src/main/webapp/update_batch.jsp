
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.funfit.bean.Batch"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Batch Edit Page</title>
</head>
<body>




<% 
Object obj = request.getAttribute("batch");
Batch b = new Batch();// type casting for that type of object.
b = (Batch)obj;
%>
<h2><%=(b == null) ? "Add Batch": "Update Batch" %></h2>
 <form action="BatchUpdateController" method="post">
 	<input type="hidden" name="batchId" value="<%=(b == null)? 0  : b.getBatchId() %>"> 
 	 
 	 
	<label>BatchName </label>
	<input type="text" name="batchName"value ="<%=(b == null) ? "" : b.getBatchName() %>"><br/>
	
	<input type="submit" value="<%=(b == null) ? "Add Batch": "Update Batch" %>"/>
	
	<input type="reset" value="reset"/>
 </form>


<a href="BatchViewController">Back</</a>
</body>
</html>