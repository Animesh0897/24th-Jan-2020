package com.ibm.eis.dao;

import java.util.HashMap;
import java.util.Map;

import com.ibm.eis.bean.Employee;

public class EmpDaoClass implements EmpDaoInterface{

	private Map<Integer,Employee> employees=new 
			HashMap<Integer,Employee>();
	
	@Override
	public void storeIntoMap(Employee employee) {
	
		employees.put(1, employee);
		
	}
	
	public Map<Integer,Employee>displayEmployees(){
		return employees;
		
		
	}
	

}
