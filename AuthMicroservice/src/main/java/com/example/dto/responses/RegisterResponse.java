package com.example.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {

//    Long id;

    String username;

    String message;

//    String email;
//
//    Boolean isActive;
//
//    Long createdAt;
}
