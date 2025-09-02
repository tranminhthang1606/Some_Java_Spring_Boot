package com.tmtjava.tmtjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtjava.tmtjava.dto.UserDTO;
import com.tmtjava.tmtjava.dto.response.UserResponse;
import com.tmtjava.tmtjava.entity.User;
import com.tmtjava.tmtjava.mapper.UserMapper;
import com.tmtjava.tmtjava.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    // @Autowired
    UserRepository userRepository;
    UserMapper userMapper;

    public User saveUser(UserDTO user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        User userEntity = userMapper.toEntity(user);

        return userRepository.save(userEntity);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public UserResponse updateUser(UserDTO user, Long id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(userEntity, user);
        return userMapper.toUserResponse(userRepository.save(userEntity));
    }

    public UserResponse getOneUser(Long id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully at id: " + id;
    }

}
