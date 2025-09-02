package com.tmtjava.tmtjava.dto;

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
public class ApiResponse<T> {
    String message;
    int code;
    String status;
    T data;

    public ApiResponse(String message, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }
}
