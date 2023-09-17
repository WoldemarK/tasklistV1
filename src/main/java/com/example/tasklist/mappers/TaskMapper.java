package com.example.tasklist.mappers;

import com.example.tasklist.dto.task.TaskDto;
import com.example.tasklist.model.task.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto> {
}
