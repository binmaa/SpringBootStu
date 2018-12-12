package com.mab.bean;

/**
 * Created by 马斌 on 2018/12/3.
 */
public class Department {
    private Integer id;
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
