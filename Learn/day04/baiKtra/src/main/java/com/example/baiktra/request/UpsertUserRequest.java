package com.example.baiktra.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertUserRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
}
