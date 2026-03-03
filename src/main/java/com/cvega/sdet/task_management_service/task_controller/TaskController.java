package com.cvega.sdet.task_management_service.task_controller;

import com.cvega.sdet.task_management_service.task.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class TaskController {
    @GetMapping(path = "/")
    public List<Task> listGenerator() {
        return List.of(new Task(111111L,"build a framework", LocalDate.of(2026, Month.MARCH,2),1), new Task(22222L,"make framework more efficient",LocalDate.of(2026,Month.MARCH,9),2));
    }
}