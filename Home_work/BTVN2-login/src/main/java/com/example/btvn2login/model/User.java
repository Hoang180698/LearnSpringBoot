package com.example.btvn2login.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private  int id;
    private String username;
    private String email;
    private String password;
    private String avatar;
}
