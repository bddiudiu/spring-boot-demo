package com.adam.springboot.demo.model;

import javax.persistence.Table;

/**
 * Created by adam on 4/11/16.
 */

@Table(name = "t_sys_users")
public class User extends BaseEntity{

    private String username;
    private String nikename;
    private String password;
    private String email;
    private Boolean sex;
    private Boolean isAdmin;
    private String salt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSex() {
        return sex;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
