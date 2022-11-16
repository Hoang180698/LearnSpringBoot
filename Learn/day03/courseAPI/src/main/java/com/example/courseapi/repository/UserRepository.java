package com.example.courseapi.repository;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> users;

    private final Faker faker;

    private UserRepository(Faker faker) {
        this.faker = faker;
        initUsers();
    }
    private void initUsers() {
        users = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            User user = new User(i,
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.avatar().image());
            users.add(user);
        }
    }

    public List<User> findAll() {
        return users;
    }
    public Optional<User> findById(int id) {
        return users.stream().filter(user1 -> user1.getId() == id).findFirst();
    }
}
