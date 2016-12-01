package com.niit.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.niit.Util.DBUtil;
import com.niit.dao.EmployeeDAO;
import com.niit.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static EmployeeDAO employeeDAO = null;
	Connection con = null;
	
	private EmployeeDAOImpl() {
		con = DBUtil.getConnection();
	}
	
	public static EmployeeDAO getEmployeeDAO() {
		if(employeeDAO==null) {
			employeeDAO = new EmployeeDAOImpl();
			
		}
		return employeeDAO;
	}
	
	
	
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> list() {
		List<Employee> employees = new ArrayList<>();
		String selectSQL = "SELECT * FROM EMPLOYEE";
		Employee employee = null;
		//fetch the code from the database
		try(Statement stmt = con.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(selectSQL);
			while(rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setWorking(rs.getBoolean("working"));
				employees.add(employee);
			}
			
		} catch (SQLException ex) {
			System.out.println("SQL error: " + ex.getMessage());
		}
		
		return employees;
	}

	@Override
	public boolean add(Employee employee) {
		
		String insertQuery  = "INSERT INTO EMPLOYEE (first_name, last_name, salary, working ) VALUES (?,?,?,?)";
		
		try ( PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
			pstmt.setString(1,  employee.getFirstName());
			pstmt.setString(2,  employee.getLastName());
			pstmt.setDouble(3,  employee.getSalary());
			pstmt.setBoolean(4,  employee.isWorking());
			
			pstmt.execute();
			return true;
		} catch (SQLException ex) {
			System.out.println("SQL error: " + ex.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
