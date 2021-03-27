<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="project.model.NewRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%!ArrayList<NewRequest> requests = new ArrayList<NewRequest>();%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<h4>Employee</h4>
	<%
	if (session.getAttribute("username") != null) {
	%>
	<p><%=session.getAttribute("username")%></p>
	<a href="logout" />Logout
	</a>
	<%}%>
	<div align="center">
		<table>
			<tr>
				<th>Id</th>
				<th>Start</th>
				<th>End</th>
				<th>Reason</th>
				<th>State</th>
			</tr>
			<%
			// retrieve your list from the request, with casting 
			ArrayList<NewRequest> requests = (ArrayList<NewRequest>) request.getAttribute("requests");

			if (requests != null) {
				if (requests.size() > 0) {
					// print the information about every category of the list
					for (NewRequest newRequest : requests) {
			%>

			<tr>
				<td><%=newRequest.getId()%></td>
				<td><%=newRequest.getStartDate()%></td>
				<td><%=newRequest.getEndDate()%></td>
				<td><%=newRequest.getReason()%></td>
				<td><%=newRequest.getState()%></td>
				<td><a href="edit?id=<c:out value='<%=newRequest.getId()%>' />">Edit</a></td>
				<td><a
					href="delete?id=<c:out value='<%=newRequest.getId()%>' />">Delete</a></td>
			</tr>
			<%
			}
			}
			} else {
			%>
			<p>La liste est vide</p>
			<%
			}
			%>

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