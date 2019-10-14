package com.mphasis.training.daos;

import java.util.List;

import com.mphasis.training.entities.Employee;


public interface EmployeeDao {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(int eid);
	public Employee getEmployeeById(int eid);
	public List<Employee> getAll();
	public List<Employee> getEmployeeByDept(int did);
	public List<Employee> getEmployeeByLoc(int lid);
	public List<Employee> getEmployeeByJob(int jid);
	public List<Employee> getEmployeeByName(String like);
}
