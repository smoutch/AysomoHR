package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import project.model.NewRequest;

public class AddRequestDao {
	public void addRequest(NewRequest request, String username) throws ClassNotFoundException {
		String LOGIN_SQL = "INSERT INTO `request`(`startDate`, `endDate`, `reason`, `state`, `idEmployee`, `idEmployer` ) VALUES (?,?,?,?,(select users.id from users where users.username = ?),(select users.idEmployer from users where users.username = ?))";

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AysomoDB", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, request.getStartDate());
			preparedStatement.setString(2, request.getEndDate());
			preparedStatement.setString(3, request.getReason());
			preparedStatement.setString(4, "Wait");
			preparedStatement.setString(5, username);
			preparedStatement.setString(6, username);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
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
