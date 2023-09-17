package com.example.tasklist.mappers;

import com.example.tasklist.dto.user.UserDto;
import com.example.tasklist.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
