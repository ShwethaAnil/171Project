package com.mphasis.training.daos;

import java.util.List;

import com.mphasis.training.entities.Job;

public interface JobDao {
	public void addJob(Job d);
	public void updateJob(Job d);
	public void deleteJob(int did);
	public Job getJobById(int did);
	public List<Job> getAll();
}
