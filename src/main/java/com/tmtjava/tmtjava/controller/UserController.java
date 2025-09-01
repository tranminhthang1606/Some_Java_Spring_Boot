package com.tmtjava.tmtjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmtjava.tmtjava.dto.UserDTO;
import com.tmtjava.tmtjava.dto.ApiResponse;
import com.tmtjava.tmtjava.entity.User;
import com.tmtjava.tmtjava.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/users")
    public ApiResponse<User> saveUser(@RequestBody @Valid UserDTO user) {
        User savedUser = userService.saveUser(user);
        return new ApiResponse<>("User created successfully", 201, "SUCCESS", savedUser);
    }

    @GetMapping("/get/users")
    public ApiResponse<List<User>> getUser() {
        List<User> users = userService.getUser();
        return new ApiResponse<>("Users retrieved successfully", 200, "SUCCESS", users);
    }

    @GetMapping("/get/users/{id}")
    public ApiResponse<User> getOneUser(@PathVariable Long id) {
        User user = userService.getOneUser(id);
        return new ApiResponse<>("User retrieved successfully", 200, "SUCCESS", user);
    }
    

    @PutMapping("/update/users/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO user) {
        User updatedUser = userService.updateUser(user, id);
        return new ApiResponse<>("User updated successfully", 200, "SUCCESS", updatedUser);
    }

    @DeleteMapping("/delete/users/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        String result = userService.deleteUser(id);
        return new ApiResponse<>(result, 200, "SUCCESS", null);
    }

}
