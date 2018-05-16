package com.tecsup.gestion.dao;

import com.tecsup.gestion.exception.DAO2Exception;
import com.tecsup.gestion.exception.EmptyResult2Exception;
import com.tecsup.gestion.model.Employee2;

public interface Employee2DAO {

	Employee2 findEmployee(int id) throws DAO2Exception, EmptyResult2Exception;

}
