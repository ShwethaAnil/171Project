package com.mphasis.training.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Location;

@Repository
public class LocationDaoImpl implements LocationDao {
	@Autowired
	SessionFactory sf;

	public void addLocation(Location l) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(l);
		session.getTransaction().commit();
		session.close();
	}

	public void updateLocation(Location l) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(l);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteLocation(int lid) {
		Session session=sf.openSession();
		session.beginTransaction();
		Location l=(Location)session.get(Location.class, lid);
		session.delete(l);
		session.getTransaction().commit();
		session.close();		
	}

	public Location getLocationById(int lid) {
		Session session=sf.openSession();
		Location l=(Location)session.get(Location.class, lid);
		return l;
	}

	public List<Location> getAll() {
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		List<Location> l=session.createCriteria(Location.class).list();
		return l;
	}
}
