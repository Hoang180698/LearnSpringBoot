package com.example.baiktra.repository;

import com.example.baiktra.database.UserData;
import com.example.baiktra.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository

public class UserRepository {

    public List<User> getAllUser(){
        return UserData.users;
    }
    public List<User> getUsersByName(String name){
        return UserData.users.stream().filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
    public Optional<User> findById(int id) {
        return UserData.users.stream().filter(user -> user.getId() == id).findFirst();
    }
    public void save(User user) {
        UserData.users.add(user);
    }
    public void delete(User user) {
        UserData.users.remove(user);
    }
}
