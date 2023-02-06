package com.example.blogbackend.service;

import com.example.blogbackend.entity.User;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.BlogRepository;
import com.example.blogbackend.repository.CommentRepository;
import com.example.blogbackend.repository.ImageRepository;
import com.example.blogbackend.repository.UserRepository;
import com.example.blogbackend.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User createUser(UpsertUserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .avatar(request.getAvatar())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();

        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
    }

    public User updateUser(Integer id, UpsertUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAvatar(request.getAvatar());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        userRepository.delete(user);
        imageRepository.deleteAllByUser(user);
        commentRepository.deleteAllByUser(user);
        blogRepository.deleteAllByUser(user);
    }
}
