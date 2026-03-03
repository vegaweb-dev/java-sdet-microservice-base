package com.cvega.sdet.task_management_service.task;

import java.time.LocalDate;

public class Task {
    private long id;
    private String taskDescription;
    private LocalDate dateOfCreation;
    private int taskAge;

    public Task() {
    }

    public Task(long id, String taskDescription, LocalDate dateOfCreation, int taskAge) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.dateOfCreation = dateOfCreation;
        this.taskAge = taskAge;
    }

    public Task(String taskDescription, LocalDate dateOfCreation, int taskAge) {
        this.taskDescription = taskDescription;
        this.dateOfCreation = dateOfCreation;
        this.taskAge = taskAge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getTaskAge() {
        return taskAge;
    }

    public void setTaskAge(int taskAge) {
        this.taskAge = taskAge;
    }
}
