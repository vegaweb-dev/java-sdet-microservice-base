package com.cvega.sdet.task_management_service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.listGenerator();
    }

    @PostMapping
    public void registerTask(@RequestBody Task task) {
        this.taskService.createNewTask(task);
    }
}



