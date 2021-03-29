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
		NewRequest newRequest = (NewRequest) request.getAttribute("request");
		%>
		<h2>Edit request</h2>
		<form action="./edit" method="post">
			<table class="table">
				<tr>
					<td>Id</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Reason</td>

				</tr>
				<tr>
					<td><%=newRequest.getId()%></td>
					<input type="hidden" name="id" value="<%=newRequest.getId()%>" />
					<td><input type="date" name="startDate"
						value="<%=newRequest.getStartDate()%>" /></td>
					<td><input type="date" name="endDate"
						value="<%=newRequest.getEndDate()%>" /></td>
					<td><input type="text" name="reason"
						value="<%=newRequest.getReason()%>" /></td>
				</tr>



			</table>
			<input class="btn btn-outline-success" type="submit" value="Edit" />
		</form>
	</div>
</body>
</html>