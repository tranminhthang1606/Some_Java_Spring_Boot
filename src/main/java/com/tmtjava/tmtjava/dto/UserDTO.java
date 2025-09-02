package com.tmtjava.tmtjava.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserDTO {
    Long id;
    String name;
    String email;
    @Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters")
    String password;
    
}
