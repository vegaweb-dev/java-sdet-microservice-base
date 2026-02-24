package com.cvega.sdet.task_management_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @GetMapping(path = "/")
    public List<String> listGenerator() {
        return List.of("wake up", "get ready", "coding");
    }
}