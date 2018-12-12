package com.mab.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mab.bean.Department;
import com.mab.bean.Employee;
import com.mab.mapper.DepartmentMapper;
import com.mab.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeDao {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	DepartmentMapper departmentMapper;

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;

	public void save(Employee employee){
		if(employee.getDepartment()!=null){
			employee.setdId(employee.getDepartment().getId());
		}
		if(employee.getId() == null){
			employeeMapper.insertEmp(employee);
			return;
		}
		employeeMapper.updateEmp(employee);
	}

	/**
	 * 获取所有员工
	 * @return
     */
	public Collection<Employee> getAll(){
		Map<Integer,Department> deptMap = new HashMap<>();
		List<Employee> emps = employeeMapper.getEmps();
		List<Department> departments = departmentMapper.getDepartments();
		if(emps == null)
			return null;
		if(departments != null){
			for(Department dept:departments){
				deptMap.put(dept.getId(),dept);
			}
		}else {
			return emps;
		}
		for(Employee emp:emps){
			if(emp.getdId()==null)
				continue;
			emp.setDepartment(deptMap.get(emp.getdId()));
		}
		return emps;
	}

	/**
	 * 通过id获取员工
	 * @param id
	 * @return
     */
	public Employee get(Integer id){
		Employee emp = employeeMapper.getEmp(id);
		if(emp != null && emp.getdId() != null){
			Department dept = departmentMapper.getDepartmentById(emp.getdId());
			emp.setDepartment(dept);
		}
		return emp;
	}

	/**
	 * 通过id删除员工
	 * @param id
     */
	public void delete(Integer id){
		employeeMapper.delete(id);
	}
}
