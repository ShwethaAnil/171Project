package com.mphasis.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.daos.JobDao;
import com.mphasis.training.entities.Job;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	JobDao JobDao;

	public void addJob(Job d) {
		JobDao.addJob(d);
	}

	public void updateJob(Job d) {
		JobDao.updateJob(d);
	}

	public void deleteJob(int did) {
		JobDao.deleteJob(did);
	}

	public Job getJobById(int did) {
		return JobDao.getJobById(did);
	}

	public List<Job> getAll() {
		return JobDao.getAll();
	}
}
