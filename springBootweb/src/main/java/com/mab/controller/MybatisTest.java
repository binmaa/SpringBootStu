package com.mab.controller;

import com.mab.bean.Department;
import com.mab.bean.Employee;
import com.mab.mapper.DepartmentMapper;
import com.mab.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 马斌 on 2018/12/3.
 */
@RestController
public class MybatisTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/getDept/{id}")
    public Department getDept(@PathVariable Integer id) {
        Department dept = departmentMapper.getDepartmentById(id);
        return dept;
    }

    @GetMapping("/getDepts")
    public List<Department> getDepts(){
        List<Department> departments = departmentMapper.getDepartments();
        return departments;
    }

    @GetMapping("/getEmps")
    public List<Employee> getEmps(){
        List<Employee> emps = employeeMapper.getEmps();
        return emps;
    }


    @GetMapping("/insertDept")
    public Department insertDept(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

    @GetMapping("/deleteDept/{id}")
    public int deleteDept(@PathVariable Integer id){
        return departmentMapper.deleteDepartmentById(id);
    }

    @GetMapping("/update")
    public int updateDept(Department department){
        return departmentMapper.updateDept(department);
    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        Employee emp = employeeMapper.getEmp(id);
        return emp;
    }
    @GetMapping("/insert")
    public Employee insertEmp(Employee employee){
        employeeMapper.insertEmp(employee);
        return employee;
    }
    @GetMapping("/deleteEmp/{id}")
    public int delete(@PathVariable("id") Integer id){
        return employeeMapper.delete(id);
    }

    @GetMapping("/updateEmp")
    public int update( Employee employee){
        return employeeMapper.updateEmp(employee);
    }
}
