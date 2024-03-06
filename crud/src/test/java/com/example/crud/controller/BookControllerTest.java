package com.example.crud.controller;

import com.example.crud.entity.Book;
import com.example.crud.service.BookService;
import com.example.crud.testUtil.BookUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    void itShouldGetAllBooks() {
        Page<Book> bookPage = BookUtil.createBookPage();

        when(bookService.getTopReadBooks(PageRequest.of(0, 5))).thenReturn(bookPage);
        ResponseEntity<List<Book>> booksResponse = bookController.getAllBooks();

        verify(bookService, times(1)).getTopReadBooks(any());
        assertEquals(booksResponse.getStatusCode(), HttpStatusCode.valueOf(200));
        assertNotNull(booksResponse);
        assertEquals(Objects.requireNonNull(booksResponse.getBody()).size(), 5);
    }
}