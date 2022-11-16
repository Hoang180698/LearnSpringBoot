package com.example.baiktra.service;

import com.example.baiktra.dto.UserDto;
import com.example.baiktra.exception.BadRequestException;
import com.example.baiktra.exception.NotFoundException;
import com.example.baiktra.model.User;
import com.example.baiktra.model.UsersListView;
import com.example.baiktra.repository.UserRepository;
import com.example.baiktra.request.AvatarUserRequest;
import com.example.baiktra.request.PassRequest;
import com.example.baiktra.request.UpdateUserRequest;
import com.example.baiktra.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findUserByName(String name) {
        List<User> users = userRepository.getUsersByName(name);
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.loadFromUser(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public UserDto findUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        UserDto userDto = new UserDto();
        userDto.loadFromUser(user);
        return userDto;
    }

    public UserDto creatUser(UpsertUserRequest request) {
        Random random = new Random();
        int id;
        while (true) {
            id = random.nextInt(1000);
            if (!userRepository.findById(id).isPresent()) {
                break;
            }
        }
        User user = new User();
        user.setId(id);
        user.setName(request.getName());
        user.setAddress(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());

        userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.loadFromUser(user);

        return userDto;
    }

    public UserDto updateUser(int id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        UserDto userDto = new UserDto();
        userDto.loadFromUser(user);

        return userDto;
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        userRepository.delete(user);
    }

    public void updateAvatar(int id, AvatarUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        user.setAvatar(request.getAvatar());
    }

    public void updatePass(int id, PassRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        if (user.getPassword().equals(request.getOldPassword())) {
            throw new BadRequestException("Mat khau cu khong chinh xac");
        }
        if (user.getPassword().equals(request.getNewPassword())) {
            throw new BadRequestException("Mat khau moi phai khac mat khau cu");
        }
        user.setPassword(request.getNewPassword());
    }

    public String forgotPass(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        Random random = new Random();
        int pass = random.nextInt(1000);
        user.setPassword(String.valueOf(pass));
        return String.valueOf(pass);
    }

    public UsersListView getAllUsers(int page, int limit) {
        List<User> userList = userRepository.getAllUser();
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = new UserDto();
            userDto.loadFromUser(user);
            usersDto.add(userDto);
        }
        UsersListView usersListView = new UsersListView();
        usersListView.setSize(limit);
        usersListView.setCurrentPage(page);
        usersListView.setTotalPage((int) Math.ceil((double) userList.size() / limit));
        usersListView.setData(usersDto.subList((page - 1) * limit,
                Math.min(usersDto.size(), page * limit)));

        return usersListView;

    }
}
