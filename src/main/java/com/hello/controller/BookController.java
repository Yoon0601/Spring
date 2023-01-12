package com.hello.controller;

import com.hello.dto.Book;
import com.hello.entity.BookEntity;
import com.hello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="/book/dto",method= RequestMethod.GET)
    public Book requestParam(@RequestParam String title, @RequestParam int price,
                             @RequestParam String author, @RequestParam String publisher){
        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        book.setAuthor(author);
        book.setPublisher(publisher);
        return book;
    }
    @PutMapping("/book")
    public Book createBook(@RequestBody Book book){
        bookService.createBook(book);
        return book;
    }

    @GetMapping("/book/{pk}")
    public Book getBook(@PathVariable Long pk){
        return bookService.getBook(pk);
    }

//    @PutMapping("/book/{pk}")
//    public Book updateBook(@PathVariable Long pk,@RequestBody Book book){
//        bookService.updateBook(book,pk);
//        return book;
//    }
}