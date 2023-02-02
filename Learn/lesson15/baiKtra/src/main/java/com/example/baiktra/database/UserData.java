package com.example.baiktra.database;

import com.example.baiktra.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserData {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"Hong","zbc@gmail.com","123456","Tỉnh Hải Dương","111","1"),
            new User(2,"Hoang","hoang180698@gmail.com","123456","Thành Phố Hà Nội","222","2"),
            new User(3,"Cuong","ccc@gmail.com","121231","Tỉnh Hưng Yên","333","3"),
            new User(4,"Cong","congphaikhong@gmail.com","3123123","Thành Phố Hải Phòng","444","4"),
            new User(5,"Tung","st@gmail.com","4213123","Tỉnh Thái Bình","555","5")
    ));
}
