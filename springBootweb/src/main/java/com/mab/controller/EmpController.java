package com.mab.controller;

import com.mab.bean.Department;
import com.mab.bean.Employee;
import com.mab.dao.DepartmentDao;
import com.mab.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by 马斌 on 2018/10/29.
 */
@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emps/list";
    }

    /**
     * 来到添加员工页面
     *
     * @return
     */
    @GetMapping(value = "/emp")
    public String toAddEmp(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emps/add";
    }

    /**
     * springMVC自动将请求参数和入参对象属性进行绑定
     *
     * @param employee
     * @return
     */
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        //redirectct 重定向到一个地址
        //转发 forward 转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 来到员工编辑页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/emp/{id}")
    public String toEditEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee);
        model.addAttribute("depts", departments);
        return "emps/add";
    }

    /**
     * 编辑员工保存
     *
     * @param employee
     * @return
     */
    @PutMapping(value = "/emp")
    public String editEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
