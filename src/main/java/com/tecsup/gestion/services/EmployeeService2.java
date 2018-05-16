package com.tecsup.gestion.services;

import com.tecsup.gestion.exception.DAO2Exception;
import com.tecsup.gestion.exception.EmptyResult2Exception;
import com.tecsup.gestion.model.Employee2;

public interface EmployeeService2 {
	
	Employee2 find(int employee_id) throws DAO2Exception, EmptyResult2Exception;

}
