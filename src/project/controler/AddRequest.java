package project.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.AddRequestDao;
import project.dao.LoginDao;
import project.model.Login;
import project.model.NewRequest;

/**
 * Servlet implementation class AddRequest
 */
@WebServlet("/addrequest")
public class AddRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddRequestDao addRequestDao;
	
	public void init() {
		addRequestDao = new AddRequestDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet !! ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/employee.jsp");
		dispatcher.forward(request, response);
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost !! ");
		//doGet(request, response);
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("reason");
		NewRequest newRequest = new NewRequest();
		newRequest.setStartDate(startDate);
		newRequest.setEndDate(endDate);
		newRequest.setReason(reason);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		 
		try {
			addRequestDao.addRequest(newRequest, username);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/employee");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home/employee.jsp");
		//dispatcher.forward(request, response);
	}

}
