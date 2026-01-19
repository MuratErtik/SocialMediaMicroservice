package com.example.contollers;

import com.example.documents.UserProfile;
import com.example.dto.requests.CreateUserRequest;
import com.example.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequest request) {
        userProfileService.createUser(request);
        return new ResponseEntity<>(true, HttpStatus.CREATED);

    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getALlUsers() {
        return ResponseEntity.ok(userProfileService.getAllUsers());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> getUpperName(String name) {
        return ResponseEntity.ok(userProfileService.upperName(name));
    }


}
