package project.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.LoginDao;
import project.model.Login;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);

		try {
			if (loginDao.validateLogin(login)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/employee.jsp");
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				// session.setAttribute("user", username);
				System.out.println("Faux !!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/employer.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}