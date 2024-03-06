package com.example.crud.testUtil;

import com.example.crud.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class BookUtil {
    public static Page<Book> createBookPage(){
        int pageSize = 5;
        int pageNumber = 0;
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), books.size());
        return new PageImpl<>(books.subList(start, end), pageable, books.size());
    }
}
