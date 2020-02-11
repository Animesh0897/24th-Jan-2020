package com.ibm.eis.service;
import java.util.Map;

import com.ibm.eis.bean.Employee;

public interface EmpServiceInterface{
	void storeIntoMap(Employee employee);
	//public abstract
	Map<Integer,Employee> displayEmployees();
}

