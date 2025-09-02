package com.tmtjava.tmtjava.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.tmtjava.tmtjava.dto.UserDTO;
import com.tmtjava.tmtjava.dto.response.UserResponse;
import com.tmtjava.tmtjava.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
    @Mapping(target = "id", ignore = true)
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserDTO userDTO);
}
