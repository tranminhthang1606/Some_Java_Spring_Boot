package com.tmtjava.tmtjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtjava.tmtjava.dto.UserDTO;
import com.tmtjava.tmtjava.entity.User;
import com.tmtjava.tmtjava.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserDTO user) {
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());

        return userRepository.save(userEntity);

    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User updateUser(UserDTO user, Long id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        return userRepository.save(userEntity);
    }

    public User getOneUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully at id: " + id;
    }

}
