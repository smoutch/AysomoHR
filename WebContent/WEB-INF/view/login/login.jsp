<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login into AysomoHR</title>
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

	<div align="center" border-style =  "solid" >
		<h3>Login into AysomoHR</h1>
		<div class="mb-3">
			<form action="./login" method="post">
				<table style="with: 100%">
					<tr>
						<td>UserName</td>
						<td><input class="form-control" type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input class="form-control" type="password"
							name="password" /></td>
					</tr>

				</table>
				<input class="btn btn-primary" type="submit" value="Submit" />
			</form>
		</div>
	</div>
</body>
</html>