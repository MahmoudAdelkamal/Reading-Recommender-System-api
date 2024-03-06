package com.example.crud.repository;

import com.example.crud.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Integer>
{
    @Query(nativeQuery = true,value = "SELECT * FROM book ORDER BY total_read_pages DESC")
    Page<Book> getTopBooks(Pageable pageable);
}
