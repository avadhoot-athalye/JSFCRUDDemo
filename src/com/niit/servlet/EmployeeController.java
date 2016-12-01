package com.niit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.EmployeeDAO;
import com.niit.daoimpl.EmployeeDAOImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    EmployeeDAO employeeDAO = EmployeeDAOImpl.getEmployeeDAO();
    
    private static final String LIST_VIEW = "listEmployee.jsp";
    private static final String FORM_VIEW = "formEmployee.jsp";
    
    
    public EmployeeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get the action
		String action = request.getParameter("action");
		String forward = null;
		
		if(action.equals("insert") || action.equals("edit")) {
			forward = FORM_VIEW;
		} else {
			//set the employee list here
			request.setAttribute("employees", employeeDAO.list());
			forward = LIST_VIEW;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
