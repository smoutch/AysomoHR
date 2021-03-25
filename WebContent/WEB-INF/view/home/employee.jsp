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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	<h4>Connected as :</h4>
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
				<td><input  type="button" name="modify" value="Modify" /></td>
				<td><input  type="button" name="delete" value="Delete" /></td>
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
		<form action="./addRequest" method="post">
			<table style="with: 100%">
				<tr>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Reason</td>

				</tr>
				<tr>
					<td><input class="form-control form-control-lg" type="date" name="startDate" /></td>
					<td><input class="form-control form-control-lg" type="date" name="endDate" /></td>
					<td><input class="form-control form-control-lg" type="text" name="reason" /></td>
				</tr>



			</table>
			<input class="btn btn-primary" type="submit" value="Add" />
		</form>
	</div>
</body>
</html>