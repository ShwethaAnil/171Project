package com.mphasis.training.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Job;

@Repository
public class JobDaoImpl implements JobDao {
	@Autowired
	SessionFactory sf;

	public void addJob(Job j) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(j);
		session.getTransaction().commit();
		session.close();
	}

	public void updateJob(Job j) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(j);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteJob(int jid) {
		Session session=sf.openSession();
		session.beginTransaction();
		Job j=(Job)session.get(Job.class, jid);
		session.delete(j);
		session.getTransaction().commit();
		session.close();		
	}

	public Job getJobById(int jid) {
		Session session=sf.openSession();
		Job j=(Job)session.get(Job.class, jid);
		return j;
	}

	public List<Job> getAll() {
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		List<Job> j=session.createCriteria(Job.class).list();
		return j;
	}
}
