package com.example.crud.controller;

import com.example.crud.dto.IntervalSubmissionResponse;
import com.example.crud.dto.SubmitReadingInterval;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/submitInterval")
    public ResponseEntity<IntervalSubmissionResponse> SubmitReadingIntervals(@RequestBody @Validated SubmitReadingInterval submitReadingInterval) {
        userService.submitInterval(submitReadingInterval);
        return new ResponseEntity<>(new IntervalSubmissionResponse("Success"), CREATED);
    }
}
