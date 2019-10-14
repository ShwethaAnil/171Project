package com.mphasis.training.service;

import java.util.List;

import com.mphasis.training.entities.Job;

public interface JobService {
	public void addJob(Job d);
	public void updateJob(Job d);
	public void deleteJob(int did);
	public Job getJobById(int did);
	public List<Job> getAll();
}
