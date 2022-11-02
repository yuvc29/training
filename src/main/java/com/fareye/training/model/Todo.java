package com.fareye.training.model;

import com.fareye.training.customAnno.DuplicateTitle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "todos")
// @DuplicateTitle(message = "Title already taken")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private String dueDate;
    private Date createdDate;
    private Date modifiedDate;
    private String body;

    // @NotNull
    private String title;
    private String status;
    private String email; // Use object user

    public Todo(String dueDate, Date createdDate, Date modifiedDate, String body, String title, String status, String email) {
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.body = body;
        this.title = title;
        this.status = status;
        this.email = email;
    }

    public Todo(){

    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "dueDate")
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    @Column(name = "createdDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "modifiedDate")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "dueDate=" + dueDate +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
