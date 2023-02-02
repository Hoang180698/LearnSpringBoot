package com.example.baiktra.model;

import com.example.baiktra.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersListView {
    private List<UserDto> data;
    private int currentPage;
    private int size;
    private int totalPage;
}
