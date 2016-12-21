package com.adam.springboot.demo.model;

import javax.persistence.Table;

/**
 * Created by adam on 10/1/16.
 */

@Table(name = "t_sys_role")
public class Role extends BaseEntity {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
