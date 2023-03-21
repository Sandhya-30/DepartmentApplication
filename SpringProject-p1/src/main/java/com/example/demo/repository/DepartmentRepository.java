package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	//to write query of our own we use @Query
	
	//@Query(value="",nativeQuery=true)
	//public Department findByDepartmentName(String departmentName);
}