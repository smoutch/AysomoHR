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

import project.dao.DeleteRequestDao;
import project.dao.GetRequestDao;
import project.dao.LoginDao;
import project.model.NewRequest;

/**
 * Servlet implementation class DeleteRequest
 */
@WebServlet("/delete")
public class DeleteRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteRequestDao deleteRequestDao;
	private GetRequestDao getRequestDao;
	ArrayList<NewRequest> requests;

	public void init() {
		deleteRequestDao = new DeleteRequestDao();
		getRequestDao = new GetRequestDao ();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteRequest() {
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
		String id = request.getParameter("id");
		System.out.println(id);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		try {
			deleteRequestDao.deleteRequest(Integer.parseInt(id));
			requests = getRequestDao.getRequests(username);
			request.setAttribute("requests", requests);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employee");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
