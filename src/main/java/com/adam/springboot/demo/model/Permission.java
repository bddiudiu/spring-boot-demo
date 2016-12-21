package com.adam.springboot.demo.model;

import javax.persistence.Table;

/**
 * Created by adam on 10/1/16.
 */

@Table(name = "t_sys_permission")
public class Permission extends BaseEntity {

    private String token;
    private String url;
    private String description;
    private Integer role;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
