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
import project.dao.RequestDao;
import project.model.NewRequest;

/**
 * Servlet implementation class EmployerServlet
 */
@WebServlet("/employer")
public class EmployerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDao requestDao;

	public void init() {
		requestDao = new RequestDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		try {
			ArrayList<NewRequest> requests = requestDao.getRequestsUsers(username);
			System.out.println(requests.size());
			request.setAttribute("requests", requests);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/employer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
