package com.tecsup.gestion.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.Employee2DAO;
import com.tecsup.gestion.exception.DAO2Exception;
import com.tecsup.gestion.exception.EmptyResult2Exception;
import com.tecsup.gestion.mapper.EmployeeMapper2;
import com.tecsup.gestion.model.Employee2;

@Repository
public class EmployeeDAO2Impl implements Employee2DAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAO2Impl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Employee2 findEmployee(int employee_id) throws DAO2Exception, EmptyResult2Exception {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM employees WHERE employee_id = ?";

		Object[] params = new Object[] { employee_id };

		try {

			Employee2 emp = (Employee2) jdbcTemplate.queryForObject(query, params, new EmployeeMapper2());
			//
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResult2Exception();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAO2Exception(e.getMessage());
		}
	}

}
