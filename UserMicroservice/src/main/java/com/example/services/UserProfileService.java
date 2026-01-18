package com.example.services;

import com.example.documents.UserProfile;
import com.example.dto.requests.CreateUserRequest;
import com.example.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public void createUser(CreateUserRequest request) {

        userProfileRepository.save(UserProfile.builder()
                        .authId(request.getAuthId())
                        .username(request.getUsername())
                        .email(request.getEmail())
                .build());

    }

    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }
}
