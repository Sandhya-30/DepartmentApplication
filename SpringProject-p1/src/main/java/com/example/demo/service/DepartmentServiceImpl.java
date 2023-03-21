package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repo;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return repo.save(department);
	}
	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
//		return repo.findById(departmentId).get();
		Optional<Department> department=repo.findById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Available");
		}
		return department.get();
		
	}
	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		 repo.deleteById(departmentId);
	}
	@Override
	public Department upadateDepartment(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department depts=repo.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depts.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depts.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depts.setDepartmentCode(department.getDepartmentCode());
		}
		
		return  repo.save(depts);
	}
	@Override
	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		//since we have no predefined method we should define our own logic
		
		return repo.findByDepartmentNameIgnoreCase(departmentName);
	}

}
