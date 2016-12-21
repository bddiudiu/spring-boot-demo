package com.adam.springboot.demo.model;

import javax.persistence.Table;

/**
 * 部门实体类
 * Created by adam on 11/12/15.
 */

@Table(name = "t_sys_dept")
public class Dept extends BaseEntity {

    private String deptName;
    private String deptDesc;
    private String deptAlias;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public String getDeptAlias() {
        return deptAlias;
    }

    public void setDeptAlias(String deptAlias) {
        this.deptAlias = deptAlias;
    }
}
