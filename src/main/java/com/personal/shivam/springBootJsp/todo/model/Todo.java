package com.personal.shivam.springBootJsp.todo.model;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class Todo {
    int id;
    String userName;
    @Size(min = 10, message = "Enter at least 10 characters.")
    String description;
    LocalDate completedBy;
    boolean done;

    public Todo(int id, String userName, String description, LocalDate completedBy, boolean done) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.completedBy = completedBy;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(LocalDate completedBy) {
        this.completedBy = completedBy;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + description + '\'' +
                ", completedBy='" + completedBy + '\'' +
                ", isDone=" + done +
                '}';
    }
}
