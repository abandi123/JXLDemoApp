package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Data {

	private List<Employee> emps;
	private List<Department> depts;

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public List<Department> getDepts() {
		return depts;
	}

	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}

	public Data() {

		emps = new ArrayList<>();
		depts = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Employee emp = new Employee(i, "emp" + i, i);
			emps.add(emp);

			Department dept = new Department("dept" + i, i);
			depts.add(dept);

		}

	}

	@Override
	public String toString() {

		emps.stream().forEach(emp -> System.out.println(
				"EmpId:" + emp.getEmployeeID() + " EmpName:" + emp.getEmployeeName() + " DeptId:" + emp.getDeptId()));

		depts.stream()
				.forEach(dept -> System.out.println("DeptId:" + dept.getDeptId() + " DeptName:" + dept.getDeptName()));
		
		
		return super.toString();
	}

}
