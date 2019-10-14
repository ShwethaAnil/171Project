package com.mphasis.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.daos.DepartmentDao;
import com.mphasis.training.entities.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentDao departmentDao;

	public void addDepartment(Department d) {
		departmentDao.addDepartment(d);
	}

	public void updateDepartment(Department d) {
		departmentDao.updateDepartment(d);
	}

	public void deleteDepartment(int did) {
		departmentDao.deleteDepartment(did);
	}

	public Department getDepartmentById(int did) {
		return departmentDao.getDepartmentById(did);
	}

	public List<Department> getAll() {
		return departmentDao.getAll();
	}
}
