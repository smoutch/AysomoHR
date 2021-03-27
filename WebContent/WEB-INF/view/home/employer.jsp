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
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h4>Manager</h4>
	<c:if test="${ !empty sessionScope.username }">
		<p>${ sessionScope.username }</p>
		<a href="logout" />Logout</a>
	</c:if>
	<div align="center">
		<table>
			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Start</th>
				<th>End</th>
				<th>Reason</th>
				<th>State</th>
			</tr>
			<tr>
				<%
				// retrieve your list from the request, with casting 
				ArrayList<NewRequest> requests = (ArrayList<NewRequest>) request.getAttribute("requests");
				if (requests != null) {
					// print the information about every category of the list
					for (NewRequest newRequest : requests) {
				%>
				<td><%=newRequest.getId()%></td>
				<td><%=newRequest.getUsername()%></td>
				<td><%=newRequest.getStartDate()%></td>
				<td><%=newRequest.getEndDate()%></td>
				<td><%=newRequest.getReason()%></td>
				<td><%=newRequest.getState()%></td>
				<td><a
					href="accept?id=<c:out value='<%=newRequest.getId()%>' />">Accept</a></td>
				<td><a
					href="refuse?id=<c:out value='<%=newRequest.getId()%>' />">Refuse</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<p>La liste est vide</p>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>