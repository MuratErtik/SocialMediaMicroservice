package com.example.services;

import com.example.dto.requests.LoginRequest;
import com.example.dto.requests.RegisterRequest;
import com.example.dto.responses.RegisterResponse;
import com.example.entities.Auth;
import com.example.repositories.AuthRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;


    public RegisterResponse register(@Valid RegisterRequest request) throws BadRequestException {

        if (!request.getPassword().equals(request.getRepassword())){
            throw new BadRequestException("Passwords do not match");
        }

        Auth auth = authRepository.save(Auth.builder()
                        .email(request.getEmail())
                        .username(request.getUsername())
                        .password(request.getPassword())

                .build());

        return RegisterResponse.builder()
                .username(auth.getUsername())
                .message("Successfully registered")
                .build();

    }


    public Boolean login(@Valid LoginRequest request) {

        return authRepository.existsByUsernameAndPassword(request.getUsername(),request.getPassword());
    }
}
