package com.example.crud.service.impl;

import com.example.crud.dto.SubmitReadingInterval;
import com.example.crud.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.crud.testUtil.UserUtil.createSubmitInterval;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void submitInterval() {
        Book book = new Book();
        book.setReadPages("[1,2,3]");
        book.setTotalReadPages(3);
        book.setName("1984");
        book.setId(1);
        SubmitReadingInterval submitReadingInterval = createSubmitInterval();

        when(bookService.getById(1)).thenReturn(book);

        Book bookResponse = userService.submitInterval(submitReadingInterval);
        verify(bookService, times(1)).saveBook(book);
        assertNotNull(bookResponse);
        assertEquals("[1,2,3,4,5,6,7,8,9,10]", bookResponse.getReadPages());
    }
}