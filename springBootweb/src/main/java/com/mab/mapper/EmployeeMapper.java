package com.mab.mapper;


import com.mab.bean.Employee;


import java.util.List;

/**
 * Created by 马斌 on 2018/12/3.
 */
// 使用@Mapper或@MapperScan扫描mapper接口
public interface EmployeeMapper {

    public Employee getEmp(Integer id);

    public int insertEmp(Employee employee);

    public int delete(Integer id);

    public List<Employee> getEmps();

    public int updateEmp(Employee employee);

}
