
<%@page import="com.funfit.service.BatchService"%>
<%@page import="com.funfit.bean.Participants"%>
<%@page import="com.funfit.bean.Batch"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Participants Update or Edit</title>
</head>
<body>
<% 
Object obj = request.getAttribute("participant");
Participants p = new Participants();// type casting for that type of object.
p = (Participants)obj;
		


BatchService bs = new BatchService();		
List<Batch> listOfBatches =  bs.listAllBatches();
Iterator<Batch> li = listOfBatches.iterator();
%>
<h2><%=(p == null) ? "Add Participant": "Update Participant" %></h2>
<form action="ParticipantUpdateController" method="post">
<input type="hidden" name="participantId" value="<%=(p == null)? 0  : p.getParticipantId()%>">
		<label>Full Name</label><input type="text" name="participantName"value ="<%=(p == null) ? "" : p.getFullName() %>"
		onfocus="this.value=''" ><br/><br/>
		<label>Batch Name</label><select name = "batchId">
		<% 
			while (li.hasNext()){
				Batch b = li.next();				
				if (p == null){ %>  <%-- Drop down list when inserting new participant  --%>
				<option name="batchId" value= <%= b.getBatchId() %>> <%=b.getBatchName() %></option>  
				<%}else{  %> <%-- Drop down list when updating participant  --%>
					<option name="batchId"  <%= ( p.getBatchId() == b.getBatchId()? "selected":"") %> value= <%= b.getBatchId() %>> <%=b.getBatchName() %></option>
				<%} %>
			
				<%} %>
				 
			</select>
		 <br/><br/>
		<label>Sex</label><input type="text" name="sex"value ="<%=(p == null) ? "" : p.getSex() %>"  ><br/>
		<label>Age</label><input type="text" name="age"value ="<%=(p == null) ? "" : p.getAge() %>"  ><br/>
		



	<input type="submit" value="<%=(p == null) ? "Add Participant": "Update Participant" %>"/>
	
	<input type="reset" value="reset"/>
 </form>

<a href="ParticipantsViewController">Back</a>
</body>
</html>