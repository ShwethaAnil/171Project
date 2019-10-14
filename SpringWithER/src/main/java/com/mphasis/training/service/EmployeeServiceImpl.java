package com.mphasis.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.daos.EmployeeDao;
import com.mphasis.training.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public void addEmployee(Employee e) {
		employeeDao.addEmployee(e);

	}

	public void updateEmployee(Employee e) {
		employeeDao.updateEmployee(e);		
	}

	public void deleteEmployee(int eid) {
		employeeDao.deleteEmployee(eid);
	}

	public Employee getEmployeeById(int eid) {
		return employeeDao.getEmployeeById(eid);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public List<Employee> getEmployeeByDept(int did) {
		return employeeDao.getEmployeeByDept(did);
	}

	public List<Employee> getEmployeeByLoc(int lid) {
		return employeeDao.getEmployeeByLoc(lid);
	}

	public List<Employee> getEmployeeByJob(int jid) {
		return employeeDao.getEmployeeByJob(jid);
	}

	public List<Employee> getEmployeeByName(String like) {
		return employeeDao.getEmployeeByName(like);
	}

}
