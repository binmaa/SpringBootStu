package com.mab.dao;

import java.util.Collection;
import java.util.List;

import com.mab.bean.Department;
import com.mab.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DepartmentDao {

	@Autowired
	DepartmentMapper departmentMapper;

	
	public Collection<Department> getDepartments(){
		List<Department> departments = departmentMapper.getDepartments();
		return departments;
	}
	
	public Department getDepartment(Integer id){
		return departmentMapper.getDepartmentById(id);
	}
	
}
