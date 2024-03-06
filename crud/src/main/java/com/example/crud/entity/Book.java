package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "total_pages")
    private int totalPages;
    @Column(name = "total_read_pages")
    private Integer totalReadPages;
    @Column(name = "read_pages")
    private String readPages;

    public Book(int id, String name, int totalPages) {
        this.id = id;
        this.name = name;
        this.totalPages = totalPages;
    }


}
