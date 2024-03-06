package com.example.crud.controller;

import com.example.crud.dto.IntervalSubmissionResponse;
import com.example.crud.dto.SubmitReadingInterval;
import com.example.crud.entity.Book;
import com.example.crud.service.UserService;
import com.example.crud.testUtil.UserUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.crud.testUtil.UserUtil.createSubmitInterval;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    void submitReadingIntervals() {
        SubmitReadingInterval submitReadingInterval = createSubmitInterval();
        ResponseEntity<IntervalSubmissionResponse> responseEntity = userController.SubmitReadingIntervals(submitReadingInterval);
        verify(userService, times(1)).submitInterval(submitReadingInterval);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}