package com.example.btvn2login.database;

import com.example.btvn2login.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    public static List<User> users = new ArrayList<>(List.of(
       new User(1,"hoang123","emai1@gmail.com","123456","avatar1")  ,
            new User(2,"noob","dasd@gmail.com","111","avatar2"),
            new User(3,"user3","emaixcz@gmail.com","abc","avatar1"),
            new User(4,"lllll","emxzc1@gmail.com","1","avatar1")
    ));
}
