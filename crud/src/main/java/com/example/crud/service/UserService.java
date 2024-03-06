package com.example.crud.service;

import com.example.crud.dto.IntervalSubmissionResponse;
import com.example.crud.dto.SubmitReadingInterval;
import com.example.crud.entity.Book;
import com.example.crud.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);

    User getById(int userId);

    void saveUser(User user);

    void deleteById(int userId);

    Book submitInterval(SubmitReadingInterval submitReadingInterval);
}
