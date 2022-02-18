package com.example.demo;

public class Employee {
	
	private Integer employeeID;
	private String employeeName;
	private Integer deptId;
	
	
	
	public Employee(Integer employeeID, String employeeName, Integer deptId) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.deptId = deptId;
	}
	
	
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	
	

}
