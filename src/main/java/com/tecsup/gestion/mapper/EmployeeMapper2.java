package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Employee2;

public class EmployeeMapper2 implements RowMapper<Employee2>{

	public Employee2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee2 emp = new Employee2();
		emp.setEmployeeId(rs.getInt("employee_id"));
		emp.setLogin(rs.getString("login"));
		emp.setPassword(rs.getString("password"));
		emp.setFirstname(rs.getString("first_name"));
		emp.setLastname(rs.getString("last_name"));
		emp.setSalary(rs.getInt("salary"));
		return emp;
	}
}
