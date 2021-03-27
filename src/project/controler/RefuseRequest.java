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

import project.dao.AcceptRequestDao;
import project.dao.GetRequestDao;
import project.dao.RefuseRequestDao;
import project.model.NewRequest;

/**
 * Servlet implementation class RefuseRequest
 */
@WebServlet("/refuse")
public class RefuseRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RefuseRequestDao refuseRequestDao;
	private GetRequestDao getRequestDao;

	public void init() {
		refuseRequestDao = new RefuseRequestDao();
		getRequestDao = new GetRequestDao ();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefuseRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		String startDate = request.getParameter("startDate");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		ArrayList<NewRequest> requests;
		try {
			refuseRequestDao.refuseRequest(Integer.parseInt(id));
			requests = getRequestDao.getRequestsUsers(username);
			request.setAttribute("requests", requests);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employer");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
