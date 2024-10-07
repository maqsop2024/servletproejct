<%@page import="java.util.Iterator"%>
<%@page import="com.funfit.bean.Batch"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Batches</title>
</head>
<body>


<h3>All Product information using JSTL</h3>
<table border="2" class="table">
	<tr>
		<th>Batch Id</th>
		<th>Batch Name</th>
	</tr>
	
	<c:forEach items="${sessionScope.listofBatches}" var="batch">
	<tr>
		<td><c:out value="${batch.batchId}"></c:out> </td>
		<td><c:out value="${batch.batchName}"></c:out> </td>
		
	</tr>
</c:forEach>
	</table>
</body>
</html>