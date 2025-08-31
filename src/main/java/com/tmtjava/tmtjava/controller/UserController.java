package com.tmtjava.tmtjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmtjava.tmtjava.dto.UserDTO;
import com.tmtjava.tmtjava.entity.User;
import com.tmtjava.tmtjava.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/users")
    public User saveUser(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get/users")
    public List<User> getUser() {
        return userService.getUser();
    }

}
