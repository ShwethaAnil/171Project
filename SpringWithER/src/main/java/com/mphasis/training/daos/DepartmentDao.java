package com.mphasis.training.daos;

import java.util.List;

import com.mphasis.training.entities.Department;

public interface DepartmentDao {
	public void addDepartment(Department d);
	public void updateDepartment(Department d);
	public void deleteDepartment(int did);
	public Department getDepartmentById(int did);
	public List<Department> getAll();
}
