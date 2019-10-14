package com.mphasis.training.service;

import java.util.List;

import com.mphasis.training.entities.Location;

public interface LocationService {
	public void addLocation(Location d);
	public void updateLocation(Location d);
	public void deleteLocation(int did);
	public Location getLocationById(int did);
	public List<Location> getAll();
}
