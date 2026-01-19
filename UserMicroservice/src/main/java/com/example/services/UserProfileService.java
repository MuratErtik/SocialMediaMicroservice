package com.example.services;

import com.example.documents.UserProfile;
import com.example.dto.requests.CreateUserRequest;
import com.example.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    private final CacheManager cacheManager;

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

    @Cacheable("upper-case")
    public String upperName(String name) {
        try {
            Thread.sleep(3000L);
        }catch (Exception e) {

        }
        return name.toUpperCase();
    }

    public void clearCache() {
        cacheManager.getCacheNames().forEach(name -> cacheManager.getCache(name).clear());//deleteAllCache
    }
}
