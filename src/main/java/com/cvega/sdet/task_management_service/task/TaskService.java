package com.cvega.sdet.task_management_service.task;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class TaskService {

    public List<Task> listGenerator() {
        return List.of(new Task(111111L, "Build a framework with selenium", LocalDate.of(2026, Month.MARCH, 2), 1), new Task(22222L, "make framework more efficient", LocalDate.of(2026, Month.MARCH, 9), 2));
    }
}
