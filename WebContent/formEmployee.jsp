<%@page import="com.niit.entity.Employee"%>
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
		Employee employee = (Employee)request.getAttribute("employee");
		if(employee==null) {
			employee = new Employee();
		}
		
	%>
		<form action = "EmployeeController.do" method="post">
			<table> 
				<tr>
					<td>Enter First Name: </td>
					<td>
						<input name = "firstName" type="text" value="<%=employee.getFirstName()%>"/>
						<input name = "id" type="hidden" value="<%=employee.getId()%>">  
					</td>	
				</tr>
				<tr>
					<td>Enter Last Name: </td>
					<td>
						<input name = "lastName" type="text" value="<%=employee.getLastName() %>" />
						
					</td>	
				</tr>
				<tr>
					<td>Enter Salary: </td>
					<td>
						<input name = "salary" type="text" value="<%=employee.getSalary()%>"/>
						
					</td>	
				</tr>
				<tr>
					<td>Working: </td>
					<td colspan="2">
						<input name = "working" type="checkbox" value="true" checked="<%if(employee.isWorking()) out.print("checked");%>"/>
						
					</td>	
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Update"/></td>
						
				</tr>
						
			</table>
		</form>
</body>
</html>