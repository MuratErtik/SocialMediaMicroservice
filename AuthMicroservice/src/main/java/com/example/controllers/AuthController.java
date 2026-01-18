package com.example.controllers;

import com.example.dto.requests.LoginRequest;
import com.example.dto.requests.RegisterRequest;
import com.example.dto.responses.RegisterResponse;
import com.example.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.example.configs.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) throws BadRequestException {

        return ResponseEntity.ok(authService.register(request));

    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody @Valid LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));

    }


}
