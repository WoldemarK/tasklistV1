package com.example.tasklist.mappers;

import com.example.tasklist.dto.task.TaskImageDto;
import com.example.tasklist.model.task.TaskImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskImageMapper extends Mappable<TaskImage, TaskImageDto> {
}
