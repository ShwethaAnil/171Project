package com.mphasis.training.daos;

import java.util.List;

import com.mphasis.training.entities.Location;

public interface LocationDao {
	public void addLocation(Location l);
	public void updateLocation(Location l);
	public void deleteLocation(int lid);
	public Location getLocationById(int lid);
	public List<Location> getAll();
}
