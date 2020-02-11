package com.ibm.eis.service;

import java.util.Map;
import com.ibm.eis.ui.Main;
import com.ibm.eis.bean.Employee;
import com.ibm.eis.dao.EmpDaoClass;

public  class EmpServiceClass implements EmpServiceInterface {

	EmpDaoClass dao = new EmpDaoClass();
	
	
	
	public String ScehemeChecker(double salary , String designation)
	{
		if((salary>5000 && salary<20000) && (designation.equals("System Associate")))
		{
			return "Scheme C";
		}
		
		else if((salary>20000 && salary<40000) && (designation.equals("Programmer")))
		{
			return "Scheme B";
		}
		else if((salary>=40000) && (designation.equals("Manager")))
		{
			return "Scheme A";
		}
		else if (salary<5000 && designation.equals("Clerk"))
		{
			return "No Scheme";
		}
	
		return "invalid";
		
		
		
	}
	
	
	
	
public void storeIntoMap(Employee employee){
		dao.storeIntoMap(employee);
		
	}
//	public void test(){
//		
//	}

	@Override
	public Map<Integer, Employee> displayEmployees() {
		
		return dao.displayEmployees();
	}


}
