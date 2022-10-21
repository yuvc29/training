package com.fareye.training.model;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private boolean verified;
    private Date created;
    private Date modified;

    public User(){

    }
    public User(String firstName, String lastName, String email, boolean verified, Date created, Date modified, String git_id, String avatar, String password, String role, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.verified = verified;
        this.created = created;
        this.modified = modified;
        this.git_id = git_id;
        this.avatar = avatar;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public String getGit_id() {
        return git_id;
    }

    public void setGit_id(String git_id) {
        this.git_id = git_id;
    }

    private String git_id;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String avatar;
    private String password;
    private String role;
    private boolean active;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

//        "firstName":"John",
//        "lastName":"Doe",
//        "email":"John.Doe@gmail.com",
//        "verified":false,
//        "created":false,
//        "modified":false,
//        "password":
//        "role"
//        "active":
//
