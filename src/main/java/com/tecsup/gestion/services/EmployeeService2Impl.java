package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.Employee2DAO;
import com.tecsup.gestion.exception.DAO2Exception;
import com.tecsup.gestion.exception.EmptyResult2Exception;
import com.tecsup.gestion.model.Employee2;

@Service
public class EmployeeService2Impl implements EmployeeService2 {

	@Autowired
	private Employee2DAO employee2DAO;

	@Override
	public Employee2 find(int employee_id) throws DAO2Exception, EmptyResult2Exception {
		
		Employee2 emp = employee2DAO.findEmployee(employee_id);

		return emp;
	}

}
