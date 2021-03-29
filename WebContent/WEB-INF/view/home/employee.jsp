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
			Employee (<%=session.getAttribute("username")%>)
		</p>
		<a class="btn btn-outline-danger" href="logout" />Logout </a>
		<%}%>
	</nav>

	<div align="center">

		<%
		// retrieve your list from the request, with casting 
		ArrayList<NewRequest> requests = (ArrayList<NewRequest>) request.getAttribute("requests");

		if (requests != null) {
			if (requests.size() > 0) {
				// print the information about every category of the list
		%>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Start</th>
				<th>End</th>
				<th>Reason</th>
				<th>State</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for (NewRequest newRequest : requests) {
			%>
			<tr>
				<td><%=newRequest.getId()%></td>
				<td><%=newRequest.getStartDate()%></td>
				<td><%=newRequest.getEndDate()%></td>
				<td><%=newRequest.getReason()%></td>
				<td><%=newRequest.getState()%></td>
				<td><a class="btn btn-outline-warning"
					href="edit?id=<c:out value='<%=newRequest.getId()%>'  />">Edit</a></td>
				<td><a class="btn btn-outline-danger"
					href="delete?id=<c:out value='<%=newRequest.getId()%>' />">Delete</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<%
			}
			} else {
			%>
			<%
			}
			%>

		</table>

		<div class="container">
			<h2>Add a new request</h2>
			<form action="./addrequest" method="post">

				<table class="table">
					<tr>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Reason</th>

					</tr>
					<tr>
						<td><input type="date" name="startDate" /></td>
						<td><input type="date" name="endDate" /></td>
						<td><input type="text" name="reason" /></td>
					</tr>

				</table>
				<input class="btn btn-outline-success" type="submit" value="Add" />
		</div>

	</div>
</body>
</html>