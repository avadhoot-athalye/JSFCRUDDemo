<%@page import="com.niit.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		//Fetching the employees
		List<Employee> employees = (List<Employee>)request.getAttribute("employees");
	%>
		<table border = "1" width="80%" align="center">
			<caption>Employee Details</caption>
			<thead>
				<tr>
					<th> First Name </th>
					<th> Last Name </th>
					<th> Salary </th>
					<th> Working </th>
					<th> &#160; </th>
				</tr>
			</thead>
			<tbody>
				<%
					for(Employee employee : employees) {
						
				%>
				
				<tr>
				
					<td><%=employee.getFirstName() %></td>
					<td><%=employee.getLastName() %></td>
					<td><%=employee.getSalary() %></td>
					<td><%=employee.isWorking() %></td>
					<td>
						<a href = "EmployeeController.do?action=edit&id=<%= employee.getId() %>">Edit</a>
						<a href = "EmployeeController.do?action=delete&id=<%= employee.getId() %>">Delete</a>
					</td>
				</tr>
				<% 
					}
				%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
						<a href = "EmployeeController.do?action=insert">Add Employee</a>
					</td>
				</tr>
				
			</tfoot>
		</table>

</body>
</html>