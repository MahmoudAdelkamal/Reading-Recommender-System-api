package com.example.crud.service.impl;

import com.example.crud.Exception.InvalidReadingIntervalException;
import com.example.crud.dto.IntervalSubmissionResponse;
import com.example.crud.utils.SetUtils;
import com.example.crud.dto.SubmitReadingInterval;
import com.example.crud.entity.Book;
import com.example.crud.repository.UserRepository;
import com.example.crud.entity.User;
import com.example.crud.service.BookService;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.crud.enums.ExceptionMessages;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.example.crud.utils.SetUtils.setToString;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookService bookService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BookService bookService) {
        this.userRepository = userRepository;
        this.bookService = bookService;
    }

    @Override
    @Transactional
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public User getById(int userId) {
        Optional<User> returnedUser = userRepository.findById(userId);
        User user;
        if (returnedUser.isPresent())
            user = returnedUser.get();
        else
            throw new RuntimeException("The user wasn't found");
        return user;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Book submitInterval(SubmitReadingInterval submitReadingInterval) {
        Book book = bookService.getById(submitReadingInterval.getBookId());
        Set<Integer> readPages = new HashSet<>();
        if(book.getReadPages() != null)  readPages = SetUtils.stringToSet(book.getReadPages());
        if(submitReadingInterval.getStartInterval()>submitReadingInterval.getEndInterval())
            throw new InvalidReadingIntervalException("The start page can't exceed the end page !!",400);
        for(int page = submitReadingInterval.getStartInterval() ; page <= submitReadingInterval.getEndInterval() ; page++)
            readPages.add(page);
        if(readPages.size() > book.getTotalPages())
            throw new InvalidReadingIntervalException("The reading interval can't exceed the book size",400);
        book.setReadPages(setToString(readPages));
        book.setTotalReadPages(readPages.size());
        bookService.saveBook(book);
        return book;
    }
}
