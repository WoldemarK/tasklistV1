package com.example.tasklist.service;

import com.example.tasklist.model.task.Task;
import com.example.tasklist.model.task.TaskImage;

import java.time.Duration;
import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long id);

    List<Task> getAllSoonTasks(Duration duration);

    Task update(Task task);

    Task create(Task task, Long userId);

    void delete(Long id);

    void uploadImage(Long id, TaskImage image);

}
