package com.cvega.sdet.task_management_service.task;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String taskDescription;
    private LocalDate dateOfCreation;
    @Transient
    private int taskAge;

    public Task() {
    }

    public Task(long id, String taskDescription, LocalDate dateOfCreation) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.dateOfCreation = dateOfCreation;
    }

    public Task(String taskDescription, LocalDate dateOfCreation) {
        this.taskDescription = taskDescription;
        this.dateOfCreation = dateOfCreation;
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
        return Period.between(this.dateOfCreation,LocalDate.now()).getDays();
    }

    public void setTaskAge(int taskAge) {
        this.taskAge = taskAge;
    }
}
