package com.hello.entity;

import com.hello.dto.Book;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private int price;
    @Column
    private String author;
    @Column
    private String publisher;

    public BookEntity(String title, int price, String author, String publisher) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public Book toDto(){
        return new Book(title,price,author,publisher);

    }

    public BookEntity() {
    }

}
