package com.tecsup.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tecsup.gestion.dao.DepartmentDAO;
import com.tecsup.gestion.exception.DAO2Exception;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResult2Exception;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.DepartmentMapper;
import com.tecsup.gestion.model.Department;

public class DepartmentDAOImpl implements DepartmentDAO{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Department findDepartment(int id) throws DAO2Exception, EmptyResult2Exception {
		String query = "SELECT department_id, city, description, name"
				+ " FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { id };

		try {

			Department emp = (Department) jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return emp;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			try {
				throw new EmptyResultException();
			} catch (EmptyResultException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			try {
				throw new DAOException(e.getMessage());
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void create(String name, String description, String city) throws DAOException {
		String query = "INSERT INTO departments (name, description, city)  VALUES ( ?,?,?)";

		Object[] params = new Object[] { name,description,city};

		Department emp = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
		

		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}		
	}

	@Override
	public void delete(int department_id) throws DAOException {
		String query = "DELETE FROM  departments WHERE department_id= ? ";

		Object[] params = new Object[] { department_id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}		
	}

	@Override
	public void update(int department_id, String name, String description, String city) throws DAOException {
		String query = "UPDATE departments SET name= ?, description=?, city= ? WHERE department_id = ?";

		Object[] params = new Object[] { name,description,city,department_id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}		
	}

	@Override
	public List<Department> findAllDepartments() throws DAOException, EmptyResultException {
		String query = "SELECT department_id, city, name, description FROM departments";

		try {

			List<Department> employees = jdbcTemplate.query(query, new DepartmentMapper());
			//
			return employees;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	
}
