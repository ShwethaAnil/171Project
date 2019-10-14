package com.mphasis.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.daos.LocationDao;
import com.mphasis.training.entities.Location;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationDao LocationDao;

	public void addLocation(Location d) {
		LocationDao.addLocation(d);
	}

	public void updateLocation(Location d) {
		LocationDao.updateLocation(d);
	}

	public void deleteLocation(int did) {
		LocationDao.deleteLocation(did);
	}

	public Location getLocationById(int did) {
		return LocationDao.getLocationById(did);
	}

	public List<Location> getAll() {
		return LocationDao.getAll();
	}
}
