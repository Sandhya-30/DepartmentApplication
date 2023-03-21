package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	private final Logger Log=LoggerFactory.getLogger(DepartmentController.class);
	
	//to save the department
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		Log.info("Inside saveDepartment of DepartmentController");
		//similarly we can add loggers inside every class
		//@RequestBody tells that the json object need to converted in to department entity;
		return service.saveDepartment(department);
		
	}
	
	//to get the list of all departments
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		return service.fetchDepartmentList();
	}
	
	//to get the particular department based on id
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return service.fetchDepartmentById(departmentId);
	}
	
	//to delete a particular record by id
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		service.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	//to update the data
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		return service.upadateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
		return service.fetchDepartmentByName(departmentName);
	}
	
}
