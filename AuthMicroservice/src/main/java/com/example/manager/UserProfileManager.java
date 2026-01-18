package com.example.manager;

import com.example.dto.requests.CreateUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.configs.RestApis.CREATE_USER;
import static com.example.configs.RestApis.USERPROFILEMANAGER;

@FeignClient(url = USERPROFILEMANAGER,name ="UserProfileManager" )
public interface UserProfileManager {

    @PostMapping(CREATE_USER)
    ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequest request);
}
