package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.Login;

public class LoginDao {

	public boolean validateLogin(Login login) throws ClassNotFoundException {
		String LOGIN_SQL = "SELECT * FROM users WHERE users.username = ? and users.password = ? ";

		Class.forName("com.mysql.jdbc.Driver");
		boolean status = false;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AysomoDB", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet result = preparedStatement.executeQuery();
			status = result.next();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
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
