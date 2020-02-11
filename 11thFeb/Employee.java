package com.ibm.eis.bean;


public class Employee {
	private String name;
	private String designation;
	private String insuranceScheme;
	private int id;
	private double salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDesignation()
	{
		return designation;
	}
	
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation + ", InsuranceScheme=" + insuranceScheme
				+ ", id=" + id + ", salary=" + salary + "]";
	}
	

	
	
	

}
