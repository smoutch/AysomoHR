<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="project.model.NewRequest"%>

<%!ArrayList<NewRequest> requests = new ArrayList<NewRequest>();%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<h4>Employee</h4>
	<%
	if (session.getAttribute("username") != null) {
	%>
	<p><%=session.getAttribute("username")%></p>
	<%}%>
	<div align="center">
		<table>
			<tr>
				<th>Start</th>
				<th>End</th>
				<th>Reason</th>
				<th>Stat</th>
			</tr>
			<tr>
				<%
				// retrieve your list from the request, with casting 
				ArrayList<NewRequest> requests = (ArrayList<NewRequest>) request.getAttribute("requests");
				
				if (requests != null) {
				// print the information about every category of the list
				for (NewRequest newRequest : requests) {
				%>
				<td><%=newRequest.getStartDate()%></td>
				<td><%=newRequest.getEndDate()%></td>
				<td><%=newRequest.getReason()%></td>
				<td><%=newRequest.getState()%></td>
				<td><input type="button" name="modify" value="Modify" /></td>
				<td><input type="button" name="delete" value="Delete" /></td>
			</tr>
			<%
			}}
				else {
					%>
					<p> La liste est vide </p>
					<%} %>
			
		</table>
		<h2>Add a new request</h2>
		<form action="./addrequest" method="post">
			<table style="with: 100%">
				<tr>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Reason</td>

				</tr>
				<tr>
					<td><input type="date" name="startDate" /></td>
					<td><input type="date" name="endDate" /></td>
					<td><input type="text" name="reason" /></td>
				</tr>



			</table>
			<input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>