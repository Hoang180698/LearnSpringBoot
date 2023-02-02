package com.example.jpabasic;

import com.example.jpabasic.dto.UserDto;
import com.example.jpabasic.dto.UserInfo;
import com.example.jpabasic.dto.UserMapper;
import com.example.jpabasic.entity.User;
import com.example.jpabasic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class User_test {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmailContainingIgnoreCase_test() {
        List<UserDto> userDtoList = userRepository.findByEmailContainingIgnoreCase("h");
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findByNameStartingWith_test() {
        List<User> users = userRepository.findByNameStartingWith("d");
        List<UserDto> userDtoList = users.stream()
                .map(user -> UserMapper.toUserDto(user))
                .toList();
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findAllUserDto_test() {
        List<UserDto> userDtoList = userRepository.findAllUserDto();
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findUserInfoByNameStartingWith_test() {
        List<UserInfo> userInfo = userRepository.findUserInfodByNameStartingWith("c");
        userInfo.forEach(u -> System.out.println(u.getId() + " - " + u.getName() + " - " +u.getEmail()));
    }
}
