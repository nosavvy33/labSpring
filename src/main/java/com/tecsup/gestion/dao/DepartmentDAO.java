package com.tecsup.gestion.dao;

import java.util.List;

import com.tecsup.gestion.exception.DAO2Exception;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResult2Exception;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;

public interface DepartmentDAO {

		Department findDepartment(int id) throws DAO2Exception, EmptyResult2Exception;

		void create(String name, String description, String city) throws DAOException;

		void delete(int department_id) throws DAOException;

		void update(int department_id,String name, String description, String city) throws DAOException;

		List<Department> findAllDepartments() throws DAOException, EmptyResultException;
		
}
