package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.model.NewRequest;

public class EditRequestDao {
	public void editRequest(NewRequest newRequest) throws ClassNotFoundException {
		String LOGIN_SQL = "update request set request.startDate = ?, request.endDate = ?, request.Reason = ?, request.state = ? where request.id = ?";

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AysomoDB", "root", "");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, newRequest.getStartDate());
			preparedStatement.setString(2, newRequest.getEndDate());
			preparedStatement.setString(3, newRequest.getReason());
			preparedStatement.setString(4, "Wait");
			preparedStatement.setInt(5, newRequest.getId());
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
