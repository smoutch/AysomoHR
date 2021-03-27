package project.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.GetRequestDao;
import project.dao.LoginDao;
import project.model.Login;
import project.model.NewRequest;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	private GetRequestDao getRequestDao;

	public void init() {
		loginDao = new LoginDao();
		getRequestDao = new GetRequestDao();
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
				HttpSession session = request.getSession();
				session.setAttribute("username", login.getUsername());
				if (loginDao.validatePost(login).equals("ee")) {
					try {
						ArrayList<NewRequest> requests = getRequestDao.getRequests(username);
						request.setAttribute("requests", requests);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//response.sendRedirect(request.getContextPath() + "/employee");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/employee");
					dispatcher.forward(request, response);
				} else {
					try {
						ArrayList<NewRequest> requests = getRequestDao.getRequestsUsers(username);
						request.setAttribute("requests", requests);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//response.sendRedirect(request.getContextPath() + "/employer");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/employer");
					dispatcher.forward(request, response);
				}

			} else {
				System.out.println("Faux !!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}