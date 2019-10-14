package com.mphasis.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.entities.Department;
import com.mphasis.training.entities.Employee;
import com.mphasis.training.entities.Job;
import com.mphasis.training.entities.Location;
import com.mphasis.training.service.DepartmentService;
import com.mphasis.training.service.EmployeeService;
import com.mphasis.training.service.JobService;
import com.mphasis.training.service.LocationService;

@RestController
public class ProjectController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	LocationService locationService;

	@Autowired
	JobService jobService;
	
	@RequestMapping(value="/empbyname/{like}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeByName(@PathVariable("like")String like){
		List<Employee> e=null;
		try {
			e=employeeService.getEmployeeByName(like);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/employees",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> viewEmployee(){
		List<Employee> e=null;
		try {
			e=employeeService.getAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/employees",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addEmployee(@RequestBody Employee e){
		try {
			employeeService.addEmployee(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/employees",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee e){
		try {
			employeeService.updateEmployee(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/employees/{eid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteEmployee(@PathVariable("eid") int eid){
		try {
			employeeService.deleteEmployee(eid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/departments",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Department> viewDepartment(){
		List<Department> e=null;
		try {
			e=departmentService.getAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/departments",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addDepartment(@RequestBody Department d){
		try {
			departmentService.addDepartment(d);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/departments",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateDepartment(@RequestBody Department d){
		try {
			departmentService.updateDepartment(d);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/department/{did}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteDepartment(@PathVariable("did") int did){
		try {
			departmentService.deleteDepartment(did);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/locations",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Location> viewLocation(){
		List<Location> e=null;
		try {
			e=locationService.getAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/locations",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addLocation(@RequestBody Location l){
		try {
			locationService.addLocation(l);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/locations",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateLocation(@RequestBody Location l){
		try {
			locationService.updateLocation(l);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/location/{lid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteLocation(@PathVariable("lid") int lid){
		try {
			locationService.deleteLocation(lid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/jobs",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Job> viewJob(){
		List<Job> e=null;
		try {
			e=jobService.getAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/jobs",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addJob(@RequestBody Job j){
		try {
			jobService.addJob(j);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	@RequestMapping(value="/jobs",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateJob(@RequestBody Job j){
		try {
			jobService.updateJob(j);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	@RequestMapping(value="/job/{jid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteJob(@PathVariable("jid") int jid){
		try {
			jobService.deleteJob(jid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value="/employeesd/{did}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeByDeptId(@PathVariable ("did") int did){
		List<Employee> e=new ArrayList<Employee>();
		try {
			e= (List<Employee>) employeeService.getEmployeeByDept(did);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/employeesj/{jid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeByJob(@PathVariable ("jid") int jid){
		List<Employee> e=new ArrayList<Employee>();
		try {
			e= (List<Employee>) employeeService.getEmployeeByJob(jid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@RequestMapping(value="/employeesl/{lid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeByLoc(@PathVariable ("lid") int lid){
		List<Employee> e=new ArrayList<Employee>();
		try {
			e= (List<Employee>) employeeService.getEmployeeByLoc(lid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
}
