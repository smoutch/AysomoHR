package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.model.NewRequest;

public class RequestDao {
	private String classForName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/AysomoDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String root = "root";
	private String password = "";

	public void refuseRequest(int id) throws ClassNotFoundException {
		String LOGIN_SQL = "update request set request.state = ? where request.id = ?";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, "Refused");
			preparedStatement.setInt(2, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
	}

	public ArrayList<NewRequest> getRequests(String username) throws ClassNotFoundException {
		ArrayList<NewRequest> requests = new ArrayList<NewRequest>();
		String LOGIN_SQL = "SELECT * FROM request WHERE request.idEmployee = (SELECT users.id from users where users.username = ?)";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				String reason = rs.getString("reason");
				String state = rs.getString("state");
				// Creating a user object to fill with user data (I imagine that you have a user
				// class in your model)
				NewRequest newRequest = new NewRequest();
				newRequest.setId(id);
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
		String LOGIN_SQL = "SELECT	users.username as username,request.id as id, request.startDate,request.endDate,request.reason,request.state "
				+ "from request inner JOIN users on request.idEmployee = users.id "
				+ "WHERE request.idEmployer = (SELECT users.id from users where users.username = ?)";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("username");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				String reason = rs.getString("reason");
				String state = rs.getString("state");
				// Creating a user object to fill with user data (I imagine that you have a user
				// class in your model)
				NewRequest newRequest = new NewRequest();
				newRequest.setId(id);
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

	public NewRequest getRequest(int id) throws ClassNotFoundException {
		NewRequest newRequest = new NewRequest();

		String LOGIN_SQL = "SELECT * FROM request WHERE request.id = ?";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setInt(1, id);

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
				newRequest.setId(id);
				newRequest.setStartDate(startDate);
				newRequest.setEndDate(endDate);
				newRequest.setReason(reason);
				newRequest.setState(state);
			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return newRequest;
	}

	public void editRequest(NewRequest newRequest) throws ClassNotFoundException {
		String LOGIN_SQL = "update request set request.startDate = ?, request.endDate = ?, request.Reason = ?, request.state = ? where request.id = ?";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);
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

	public void deleteRequest(int id) throws ClassNotFoundException {
		String LOGIN_SQL = "DELETE FROM `request` WHERE request.id = ?";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
	}

	public void addRequest(NewRequest request, String username) throws ClassNotFoundException {
		String LOGIN_SQL = "INSERT INTO `request`(`startDate`, `endDate`, `reason`, `state`, `idEmployee`, `idEmployer` ) VALUES (?,?,?,?,(select users.id from users where users.username = ?),(select users.idEmployer from users where users.username = ?))";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);
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

	public void acceptRequest(int id) throws ClassNotFoundException {
		String LOGIN_SQL = "update request set request.state = ? where request.id = ?";

		Class.forName(classForName);
		try (Connection connection = DriverManager.getConnection(url, root, password);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
			preparedStatement.setString(1, "Accepted");
			preparedStatement.setInt(2, id);
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
