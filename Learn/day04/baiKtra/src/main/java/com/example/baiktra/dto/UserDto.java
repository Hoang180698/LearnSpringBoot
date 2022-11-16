package com.example.baiktra.dto;

import com.example.baiktra.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;

    public void loadFromUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.address = user.getAddress();
        this.email = user.getPhone();
        this.avatar = user.getAvatar();
        this.phone = user.getPhone();
    }
}
