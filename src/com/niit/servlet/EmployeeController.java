package com.niit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.niit.dao.EmployeeDAO;
import com.niit.daoimpl.EmployeeDAOImpl;
import com.niit.entity.Employee;

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
		
		if(action.equals("insert")) {
			
			forward = FORM_VIEW;
		} 
		
		else if (action.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Employee employee = employeeDAO.get(id);
			//set the employee
			request.setAttribute("employee", employee);
			forward = FORM_VIEW;
			
		} else if(action.equals("delete")) {
			//get the id for deleting
			int id = Integer.parseInt(request.getParameter("id"));
			employeeDAO.delete(id);
			request.setAttribute("employees", employeeDAO.list());
			forward = LIST_VIEW;
		}
		
		else {
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
		// employee saving or update code will come here
		// get the values from the form
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		boolean working = Boolean.parseBoolean(request.getParameter("working"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		//New Employee object
		//Set the value from the form to the object
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		employee.setWorking(working);
		
		System.out.println(employee);
		
			if(id == 0) {
				employeeDAO.add(employee);
			} else {
				employeeDAO.update(employee);
			} 
		
		response.sendRedirect("index.jsp");
		
//		doGet(request, response);
	}

}
