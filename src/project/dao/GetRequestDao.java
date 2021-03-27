package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.model.NewRequest;

public class GetRequestDao {
	public ArrayList<NewRequest> getRequests(String username) throws ClassNotFoundException {
		ArrayList<NewRequest> requests = new ArrayList<NewRequest>();
		String LOGIN_SQL = "SELECT * FROM request WHERE request.idEmployee = (SELECT users.id from users where users.username = ?)";

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AysomoDB", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				String reason = rs.getString("reason");
				String state = rs.getString("state");
				// Creating a user object to fill with user data (I imagine that you have a user
				// class in your model)
				NewRequest newRequest = new NewRequest();
				newRequest.setStartDate(startDate);
				newRequest.setEndDate(endDate);
				newRequest.setReason(reason);
				newRequest.setState(state);
				// Add the retrived user to the list
				requests.add(newRequest);
			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return requests;
	}

	public ArrayList<NewRequest> getRequestsUsers(String username) throws ClassNotFoundException {
		ArrayList<NewRequest> requests = new ArrayList<NewRequest>();
		String LOGIN_SQL = "SELECT	users.username as username,request.startDate,request.endDate,request.reason,request.state "
				+ "from request inner JOIN users on request.idEmployee = users.id "
				+ "WHERE request.idEmployer = (SELECT users.id from users where users.username = ?)";

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AysomoDB", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String nom = rs.getString("username");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				String reason = rs.getString("reason");
				String state = rs.getString("state");
				// Creating a user object to fill with user data (I imagine that you have a user
				// class in your model)
				NewRequest newRequest = new NewRequest();
				newRequest.setUsername(nom);
				newRequest.setStartDate(startDate);
				newRequest.setEndDate(endDate);
				newRequest.setReason(reason);
				newRequest.setState(state);
				// Add the retrived user to the list
				requests.add(newRequest);
			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return requests;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
