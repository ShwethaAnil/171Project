package com.mphasis.training.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dept")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	
	@Column(length=10)
	private String dname;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Location loc;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Employee> employees;
	
	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	
	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}	
	
}
