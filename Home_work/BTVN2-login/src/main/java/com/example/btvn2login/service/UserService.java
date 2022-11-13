package com.example.btvn2login.service;

import com.example.btvn2login.dto.UserDto;
import com.example.btvn2login.exception.NotFoundException;
import com.example.btvn2login.model.User;
import com.example.btvn2login.repository.UserRepository;
import com.example.btvn2login.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto login(UpsertUserRequest request) {
        UserDto userDto = new UserDto();
        Optional<User> userOptional = userRepository.login(request);
        if (userOptional.isPresent()) {
            userDto.loadFromModel(userOptional.get());
            return userDto;
        }
        throw new NotFoundException("username hoặc password chưa chính xác");
    }
}
