package com.fareye.training.model;

import com.fareye.training.customAnno.DuplicateTitle;

import javax.validation.constraints.NotNull;

import java.util.Date;


@DuplicateTitle(message = "Title already taken")
public class Todo {
    private Date dueDate;
    private Date createdDate;
    private Date modifiedDate;
    private String body;

    @NotNull
    private String title;
    private String status;
    private String user; // Use object user

    public Todo(Date dueDate, Date createdDate, Date modifiedDate, String body, String title, String status, String user) {
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.body = body;
        this.title = title;
        this.status = status;
        this.user = user;
    }

    public Todo(){

    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

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
                ", user='" + user + '\'' +
                '}';
    }
}
