package com.mphasis.training.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Department;
import com.mphasis.training.entities.Employee;
import com.mphasis.training.entities.Job;
import com.mphasis.training.entities.Location;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	SessionFactory sf;

	public void addEmployee(Employee e) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(Employee e) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(e);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEmployee(int eid) {
		Session session=sf.openSession();
		session.beginTransaction();
		Employee e=(Employee)session.get(Employee.class, eid);
		session.delete(e);
		session.getTransaction().commit();
		session.close();		
	}

	public Employee getEmployeeById(int eid) {
		Session session=sf.openSession();
		Employee e=(Employee)session.get(Employee.class, eid);
		return e;
	}

	public List<Employee> getAll() {
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> e=session.createCriteria(Employee.class).list();
		return e;
	}

	public List<Employee> getEmployeeByDept(int did) {
		Session session=sf.openSession();
		Department dept=(Department) session.get(Department.class, did);
		@SuppressWarnings("unchecked")
		List<Employee> e=session.createCriteria(Employee.class).add(Restrictions.eq("dept", dept)).list();
		return e;
	}

	public List<Employee> getEmployeeByLoc(int lid) {
		Session session=sf.openSession();
		Location loc=(Location)session.get(Location.class, lid);
		@SuppressWarnings("unchecked")
		List<Department> dept=session.createCriteria(Department.class).add(Restrictions.eq("loc",loc)).list();
		@SuppressWarnings("unchecked")
		List<Employee> e=session.createCriteria(Employee.class).add(Restrictions.in("dept",dept)).list();
		return e;
	}

	public List<Employee> getEmployeeByJob(int jid) {
		Session session=sf.openSession();
		Job job=(Job) session.get(Job.class, jid);
		@SuppressWarnings("unchecked")
		List<Employee> e=session.createCriteria(Employee.class).add(Restrictions.eq("job", job)).list();
		return e;
	}

	public List<Employee> getEmployeeByName(String like) {
		Session session=sf.openSession();
		like=like+"%";
		@SuppressWarnings("unchecked")
		List<Employee> e=session.createCriteria(Employee.class).add(Restrictions.ilike("ename", like)).list();
		return e;
	}
}
