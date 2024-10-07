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
<h3>Using request.setAttribute method</h3>


<table border="2" class="table">
	<tr>
		<th>Batch Id</th>
		<th>Batch Name</th>
		<th>Action</th>
		
	</tr>
	
	<% String msg = (String)request.getAttribute("message");
		if(msg != null){
			%>    <p style="color:red;"><%= msg %></p><%
		}
	%>
	
	
	
	<%
	Object obj = request.getAttribute("listOfBatches");
	List<Batch> listOfBatch = (List<Batch>)obj;// type casting for that type of object. 
	Iterator<Batch> li = listOfBatch.iterator();
			while(li.hasNext()){
				Batch b = li.next();
				%>
				<tr>
					<td> <%=b.getBatchId() %> </td>
					<td> <%=b.getBatchName()%> </td>
					<td>  <a href="BatchUpdateController?batchId=<%=b.getBatchId()%>">Edit</a> 
					  <a href="BatchDeleteController?batchId=<%=b.getBatchId()%>" onclick="return confirm('Are you sure?')">Delete</a>	</td>				
				</tr>
				<%
			}
	%>
</table>
<br>
<a href="index.html">Main Page</a> 
<a href="BatchUpdateController?batchId=0">Add Batch</a>


</body>
</html>