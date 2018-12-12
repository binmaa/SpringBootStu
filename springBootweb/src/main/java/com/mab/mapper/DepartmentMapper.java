package com.mab.mapper;

import com.mab.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 马斌 on 2018/12/3.
 */
//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delet from department where id = #{id}")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDepartment(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDept(Department department);

    @Select("select * from department")
    public List<Department> getDepartments();
}


