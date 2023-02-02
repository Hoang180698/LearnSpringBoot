package com.example.userbackend;

import com.example.userbackend.model.User;
import com.example.userbackend.model.dto.UserDto;
import com.example.userbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserBackendApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        List<User> a = userRepository.findByNameContainingIgnoreCase("hoang");
        a.forEach(System.out::println);
    }

}
