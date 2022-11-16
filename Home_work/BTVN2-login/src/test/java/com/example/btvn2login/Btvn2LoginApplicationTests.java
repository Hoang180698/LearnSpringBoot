package com.example.btvn2login;

import com.example.btvn2login.dto.UserDto;
import com.example.btvn2login.request.UpsertUserRequest;
import com.example.btvn2login.service.ColorService;
import com.example.btvn2login.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Btvn2LoginApplicationTests {

    @Autowired
    private ColorService colorService;
    private UserService userService;
    @Test
    void test_Login() {
        UpsertUserRequest request = new UpsertUserRequest("hoang123", "123456");

        UserDto userDto = userService.login(request);

        assertThat(userDto).isNotNull();
        assertThat(userDto.getUsername()).isEqualTo("hoang123");
        assertThat(userDto).isInstanceOf(UserDto.class);
    }

}
