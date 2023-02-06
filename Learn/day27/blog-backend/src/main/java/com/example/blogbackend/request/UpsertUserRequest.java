package com.example.blogbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertUserRequest {
    private Integer id;
    private String name;
    private String email;
    private String avatar;
    private String password;
}
