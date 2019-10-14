package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="loc")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	
	@Column(length=10)
	private String lname;
	
	@OneToMany(mappedBy="loc",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Department> dept=new ArrayList<Department>();
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<Department> getDept() {
		return dept;
	}
	public void setDept(List<Department> dept) {
		this.dept = dept;
	}
	
	
	
}
