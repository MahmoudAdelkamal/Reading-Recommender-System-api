package com.example.crud.service.impl;

import com.example.crud.Exception.BookNotFoundException;
import com.example.crud.repository.BookRepository;
import com.example.crud.entity.Book;
import com.example.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.crud.enums.ExceptionMessages.BOOK_NOT_FOUND;

@Service
public class BookServiceImpl implements BookService
{
    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }
    @Override
    public Page<Book> getAllBooks(Pageable pageable)
    {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> getTopReadBooks(Pageable pageable) {
        return bookRepository.getTopBooks(pageable);
    }


    @Override
    public Book getById(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException(BOOK_NOT_FOUND.message, 404));
    }
    @Override
    public void saveBook(Book book)
    {
        bookRepository.save(book);
    }


}
