package com.cvega.sdet.task_management_service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listGenerator() {
        return this.taskRepository.findAll(); /*List.of(new Task(111111L, "Build a framework with selenium", LocalDate.of(2026, Month.MARCH, 2), 1), new Task(22222L, "make framework more efficient", LocalDate.of(2026, Month.MARCH, 9), 2));*/
    }

    public void createNewTask(Task task) {
        Optional<Task> res = taskRepository.findByTaskDescription(task.getTaskDescription());
        if (res.isPresent()) {
            throw new IllegalArgumentException("This task is already registered");
        }
        taskRepository.save(task);
    }
}
