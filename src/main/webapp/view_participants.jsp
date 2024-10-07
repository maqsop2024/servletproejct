<%@page import="java.util.Iterator"%>
<%@page import="com.funfit.bean.Participants"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Participants</title>
</head>
<body>
<h3>View All Participants</h3>
<% String msg = (String)request.getAttribute("message");
		if(msg != null){
			%>    <p style="color:red;"><%= msg %></p><%
		}
	%>
<table border="2" class="table">
	<tr>
		<th>Participant Id</th>
		<th>Batch Name</th>
		<th>Full Name</th>
		<th>Sex</th>
		<th>Age</th>
		<th>Action</th>
	</tr>
	<%
	Object obj = request.getAttribute("listOfParticipants");
	
	List<Participants> listOfParticipants = (List<Participants>)obj;// type casting for that type of object. 
	Iterator<Participants> li = listOfParticipants.iterator();
			while(li.hasNext()){
				Participants b = li.next();
				%>
				<tr>
					<td> <%=b.getParticipantId() %> </td>
					<td> <%=b.getBatchName() %> </td>
					<td> <%=b.getFullName()%> </td>
					<td> <%=b.getSex()%> </td>
					<td> <%=b.getAge()%> </td>	
					<td>  <a href="ParticipantUpdateController?participantId=<%=b.getParticipantId()%>">Edit</a> 
					  <a href="ParticipantDeleteController?participantId=<%=b.getParticipantId()%>" onclick="return confirm('Are you sure?')">Delete</a>	</td>				
				</tr>
				<%
			}
	%>
</table>
<a href="index.html">Main Page</a> 
<a href="ParticipantUpdateController?participantId=0">Add Participant</a>
</body>
</html>