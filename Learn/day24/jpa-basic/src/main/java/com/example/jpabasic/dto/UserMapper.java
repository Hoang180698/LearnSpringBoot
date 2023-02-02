package com.example.jpabasic.dto;

import com.example.jpabasic.entity.User;

public class UserMapper {
    public static UserDto toUserDto (User user) {
       return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
