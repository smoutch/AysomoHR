<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="project.model.NewRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	padding: 10px 50px;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<!-- Navbar content -->
		<h4>AysomoHR</h4>
		<%
		if (session.getAttribute("username") != null) {
		%>
		<p>
			Manager (<%=session.getAttribute("username")%>)
		</p>
		<a class="btn btn-danger" href="logout" />Logout </a>
		<%}%>
	</nav>

	<div align="center">
		<%
		// retrieve your list from the request, with casting 
		ArrayList<NewRequest> requests = (ArrayList<NewRequest>) request.getAttribute("requests");
		if (requests != null) {
			// print the information about every category of the list
			if (requests.size() > 0) {
		%>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Start</th>
				<th>End</th>
				<th>Reason</th>
				<th>State</th>
				<th>Accept</th>
				<th>Refuse</th>

			</tr>
			<%
			for (NewRequest newRequest : requests) {
				if (newRequest.getState().equals("Refused")) {
			%>
			<tr class="table-danger">
				<%
				} else if (newRequest.getState().equals("Accepted")) {
				%>
			
			<tr class="table-success">
				<%
				} else {
				%>
			
			<tr>
				<%
				}
				%>
				<td><%=newRequest.getId()%></td>
				<td><%=newRequest.getUsername()%></td>
				<td><%=newRequest.getStartDate()%></td>
				<td><%=newRequest.getEndDate()%></td>
				<td><%=newRequest.getReason()%></td>
				<td><%=newRequest.getState()%></td>
				<td><a class="btn btn-success"
					href="accept?id=<c:out value='<%=newRequest.getId()%>' />">Accept</a></td>
				<td><a class="btn btn-danger"
					href="refuse?id=<c:out value='<%=newRequest.getId()%>' />">Refuse</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<p>Empty !!</p>
			<%
			}

			} else {
			%>
			<p>Empty !!</p>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>