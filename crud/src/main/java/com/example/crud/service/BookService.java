package com.example.crud.service;

import com.example.crud.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> getAllBooks(Pageable pageable);
    Page<Book> getTopReadBooks(Pageable pageable);

    Book getById(int bookId);

    void saveBook(Book book);

}
