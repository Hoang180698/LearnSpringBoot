package com.example.baiktra.database;

import com.example.baiktra.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserData {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"Hong","u1@gmail.com","123456","CG","111","1"),
            new User(2,"Hoang","u1@gmail.com","123456","HN","222","1"),
            new User(3,"Cuong","u1@gmail.com","121231","HD","333","1"),
            new User(4,"Cong","u1@gmail.com","3123123","TH","444","1"),
            new User(5,"aaa","u1@gmail.com","4213123","HP","555","1")
    ));
}
