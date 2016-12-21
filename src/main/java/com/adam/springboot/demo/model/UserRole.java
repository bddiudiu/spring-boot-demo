package com.adam.springboot.demo.model;

import javax.persistence.Table;

/**
 * Created by adam on 10/1/16.
 */

@Table(name = "t_sys_user_role")
public class UserRole extends BaseEntity {

    private Integer user;
    private Integer role;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
