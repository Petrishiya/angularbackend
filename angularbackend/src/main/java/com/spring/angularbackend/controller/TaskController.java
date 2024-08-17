package com.spring.angularbackend.controller;


import com.spring.angularbackend.pojo.Task;
import com.spring.angularbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/getTasks")
    public List<Task> getAllTasks() {

        System.out.println("Tasks");
        return taskService.getAllTasks();
    }

    @PostMapping("/createTasks")
    public Task createTask(@RequestBody Task task) {


        return taskService.saveTask(task);
    }


    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


    @GetMapping("/assignees")
    public List<String> getAssignees() {
        return taskService.getAssignees();
    }

    @GetMapping("/creators")
    public List<String> getCreators() {
        return taskService.getCreators();
    }

    @GetMapping("/statuses")
    public List<String> getStatuses() {
        return taskService.getStatuses();
    }
}
