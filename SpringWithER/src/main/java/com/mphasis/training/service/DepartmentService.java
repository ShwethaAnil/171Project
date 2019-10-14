package com.mphasis.training.service;

import java.util.List;

import com.mphasis.training.entities.Department;

public interface DepartmentService {
	public void addDepartment(Department d);
	public void updateDepartment(Department d);
	public void deleteDepartment(int did);
	public Department getDepartmentById(int did);
	public List<Department> getAll();
}
