package com.mphasis.training.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	SessionFactory sf;

	public void addDepartment(Department d) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		session.close();
	}

	public void updateDepartment(Department d) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(d);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteDepartment(int did) {
		Session session=sf.openSession();
		session.beginTransaction();
		Department d=(Department)session.get(Department.class, did);
		session.delete(d);
		session.getTransaction().commit();
		session.close();		
	}

	public Department getDepartmentById(int did) {
		Session session=sf.openSession();
		Department d=(Department)session.get(Department.class, did);
		return d;
	}

	public List<Department> getAll() {
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		List<Department> d=session.createCriteria(Department.class).list();
		return d;
	}
}
