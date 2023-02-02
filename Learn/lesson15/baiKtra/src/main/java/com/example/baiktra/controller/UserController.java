package com.example.baiktra.controller;

import com.example.baiktra.dto.UserDto;
import com.example.baiktra.model.User;
import com.example.baiktra.model.UsersListView;
import com.example.baiktra.request.AvatarUserRequest;
import com.example.baiktra.request.PassRequest;
import com.example.baiktra.request.UpdateUserRequest;
import com.example.baiktra.request.UpsertUserRequest;
import com.github.javafaker.Avatar;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.baiktra.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // Lấy danh sách list user
    @GetMapping("allUsers")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    //GET http://localhost:8080/api/v1/users : Lấy danh sách users
    @GetMapping("users")
    public UsersListView getAllUsers(@RequestParam(defaultValue = "1", required = false) Integer page,
                                     @RequestParam(defaultValue = "10", required = false) Integer limit){
        return userService.getAllUsers(page, limit);
    }

    //GET http://localhost:8080/api/v1/search?name={nameValue}:  Tìm kiếm user theo tên
    @GetMapping("search")
    public List<UserDto> findUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    //GET http://localhost:8080/api/v1/users/{id}: Lấy chi tiết user theo id
    @GetMapping("users/{id}")
    public UserDto findUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    //POST http://localhost:8080/api/v1/users: Tạo mới user
    @PostMapping("users")
    public UserDto creatUser(@RequestBody UpsertUserRequest request) {
        return userService.creatUser(request);
    }

    //PUT http://localhost:8080/api/v1/users/{id}:  Cập nhật thông tin user
    @PutMapping("users/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    //DELETE http://localhost:8080/api/v1/users/{id}: Xóa user
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    //Thay đổi mật khẩu
    //PUT http://localhost:8080/api/v1/users/{id}/update-password
    @PutMapping("users/{id}/update-password")
    public void changePass(@PathVariable int id, @RequestBody PassRequest request) {
        userService.updatePass(id, request);
    }

    // Thay đổi ảnh avatar
    // PUT http://localhost:8080/api/v1/users/{id}/update-avatar
//    @PutMapping("users/{id}/update-avatar")
//    public void updateAvatar(@PathVariable int id, @RequestBody AvatarUserRequest request) {
//        userService.updateAvatar(id, request);
//    }


    //Quên mật khẩu
    //POST http://localhost:8080/api/v1/users/{id}/fotgot-password
    @PostMapping("users/{id}/forgot-password")
    public String forgotPass(@PathVariable int id) {
        return userService.forgotPass(id);
    }


    // Upload ảnh
    // c1 : Lưu trực tiếp vào database
    // c2 : Lưu ảnh vào 1 folder ở server -> lưu path image vào database
    // Trong trường hợp k có database : Lưu ảnh vào 1 folder ở server
    // -> sử dụng userId, fileId để tìm kiếm trong folder

    // uploads
    // 1, 2, 3 : folder tương ứng với userId
    // trong folder userId là các ảnh mà user đó upload

    @PostMapping("/users/{id}/files")
    public ResponseEntity<?> uploadFile(@PathVariable int id, @ModelAttribute("file")MultipartFile file) {
        String filePath = userService.uploadFile(id, file);
        return ResponseEntity.ok(filePath);
    }

    // Xem ảnh -> byte[]
    @GetMapping("/users/{id}/files/{fileId}")
    public ResponseEntity<?> readFile(@PathVariable int id, @PathVariable String fileId) {
        byte[] bytes = userService.readFile(id, fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    // Lấy danh sách ảnh
    // /api/v1/users/2/files/1671023375
    @GetMapping("users/{id}/files")
    public ResponseEntity<?> getFiles(@PathVariable int id) {
        List<String> files = userService.getFiles(id);
        return ResponseEntity.ok(files); // 200
    }

    // Xóa ảnh
    @DeleteMapping("users/{id}/files/{fileId}")
    public ResponseEntity<?> deleteFiles(@PathVariable int id, @PathVariable String fileId) {
       userService.deleteFile(id, fileId);
       return ResponseEntity.noContent().build(); //204
    }

    //update avatar
    @PutMapping("users/{id}/update-avatar")
    public ResponseEntity<?> updateAvatar(@PathVariable int id, @RequestBody AvatarUserRequest request) {
       userService.updateAvatar(id, request);
        return ResponseEntity.noContent().build();
    }
}
