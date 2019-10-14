package com.mphasis.training.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;
	@Column(length=10,nullable=false)
	private String ename;
	@Column(precision=10,scale=2)
	private double salary;
	@Column(length=10,columnDefinition="date default sysdate")
	private String doj;
	//@Column(length=10)
	@ManyToOne(cascade=CascadeType.ALL)
	private Department dept;
	//@Column(length=10)
	@ManyToOne(cascade=CascadeType.ALL)
	private Job job;
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}

	private int bonus;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", doj=" + doj + ", department="
				+ dept + ", job=" + job + ", bonus=" + bonus + "]";
	}
	
}
