package project.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.dao.RequestDao;
import project.model.NewRequest;

/**
 * Servlet implementation class ModifyRequestServlet
 */
@WebServlet("/edit")
public class EditRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewRequest newRequest;
	ArrayList<NewRequest> requests;
	private RequestDao requestDao;

	public void init() {
		requestDao = new RequestDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditRequestServlet() {
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
		request.setAttribute("id", id);
		try {
			newRequest = requestDao.getRequest(Integer.parseInt(id));
			request.setAttribute("request", newRequest);
		} catch (NumberFormatException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/request/editRequest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("reason");
		newRequest.setId(Integer.parseInt(id));
		newRequest.setStartDate(startDate);
		newRequest.setEndDate(endDate);
		newRequest.setReason(reason);
		try {
			requestDao.editRequest(newRequest);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/employee");
	}

}
