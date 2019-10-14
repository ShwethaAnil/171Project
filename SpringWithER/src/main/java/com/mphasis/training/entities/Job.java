package com.mphasis.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jcode;
	
	@Column(length=10)
	private String jname;
	
	@OneToMany(mappedBy="job",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Employee> employees;
	
	public int getJcode() {
		return jcode;
	}
	public void setJcode(int jcode) {
		this.jcode = jcode;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
