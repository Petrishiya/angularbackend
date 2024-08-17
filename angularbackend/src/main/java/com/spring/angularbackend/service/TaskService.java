package com.spring.angularbackend.service;

import com.spring.angularbackend.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.angularbackend.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


    public List<String> getAssignees() {
        // Example: return a static list, or fetch distinct assignees from tasks
        return List.of("Magdalin", "Sourav", "Venu");
    }

    public List<String> getCreators() {
        // Example: return a static list, or fetch distinct creators from tasks
        return List.of("Magdalin", "Sourav", "Venu");
    }

    public List<String> getStatuses() {
        // Example: return a static list of statuses
        return List.of("TO-DO", "INPROGRESS", "READY FOR QA", "DONE");
    }
}
