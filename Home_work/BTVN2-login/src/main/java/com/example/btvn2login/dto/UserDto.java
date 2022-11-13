package com.example.btvn2login.dto;

import com.example.btvn2login.model.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private String username;
    private String email;
    private String avatar;

    public void loadFromModel(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
    }
}
