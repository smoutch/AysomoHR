<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	<c:if test="${ !empty sessionScope.username }">
		<p>${ sessionScope.username }</p>
	</c:if>
	<div align="center">
		<table>
			<tr>
				<th>Start</th>
				<th>End</th>
				<th>Reason</th>
				<th>Stat</th>
			</tr>
			<tr>
				<td>02-02-2021</td>
				<td>02-02-2021</td>
				<td>Vacation</td>
				<td>Valide</td>
				<td><input type="button" name="modify" value="Modify" /></td>
				<td><input type="button" name="delete" value="Delete" /></td>
			</tr>
			<tr>
				<td>02-02-2021</td>
				<td>02-02-2021</td>
				<td>Vacation</td>
				<td>Valide</td>
				<td><input type="button" name="modify" value="Modify" /></td>
				<td><input type="button" name="delete" value="Delete" /></td>
			</tr>
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