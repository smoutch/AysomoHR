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
	<%}%>
	<div align="center">
		<%
			// retrieve your list from the request, with casting 
			NewRequest newRequest = (NewRequest) request.getAttribute("request");
			%>
		<h2>Edit request</h2>
		<form action="./edit" method="post">
			<table style="with: 100%">
				<tr>
					<td>Id</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Reason</td>

				</tr>
				<tr>
					<td><%=newRequest.getId()%></td>
					<input type="hidden" name="id" value="<%=newRequest.getId()%>" />
					<td><input type="date" name="startDate" value="<%=newRequest.getStartDate()%>" /></td>
					<td><input type="date" name="endDate" value="<%=newRequest.getEndDate()%>" /></td>
					<td><input type="text" name="reason" value="<%=newRequest.getReason()%>" /></td>
				</tr>



			</table>
			<input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>