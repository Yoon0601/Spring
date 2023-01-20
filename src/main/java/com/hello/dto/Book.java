package com.hello.dto;

import com.hello.entity.BookEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Book {
    private String title;
    private int price;
    private String author;
    private String publisher;

    public Book(String title, int price, String author, String publisher) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public Book() {
    }


    public BookEntity toEntity(){
        return new BookEntity(title,price,author,publisher);
    }
//    public void bookprint(Book book){
//        System.out.println("title : "+ book.getTitle());
//        System.out.println("author : "+book.getAuthor());
//        System.out.println("price : "+book.getPrice());
//        System.out.println("publisher : "+book.getPublisher());
//    }
//
//    Timestamp r_time;
//    Timestamp m_time;
}

