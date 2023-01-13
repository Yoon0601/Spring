package com.hello.entity;

import com.hello.dto.Book;
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
    public void updatebook(Book book){
        this.title=book.getTitle();
        this.price=book.getPrice();
        this.author=book.getAuthor();
        this.publisher= book.getPublisher();
    }
    public BookEntity() {
    }

}
