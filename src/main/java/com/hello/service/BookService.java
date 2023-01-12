package com.hello.service;

import com.hello.dto.Book;
import com.hello.entity.BookEntity;
import com.hello.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository ;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Transactional
    public BookEntity createBook(Book book) {
        return bookRepository.save(book.toEntity());
    }

    @Transactional
    public Book getBook(Long id) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(()->new NullPointerException());
        return entity.toDto();
    }

//    @Transactional
//    public Book updateBook(Book book,Long id){
//        BookEntity entity = bookRepository.findById(id)
//                .orElseThrow(()->new NullPointerException());
//        entity=bookRepository.save(book.toEntity());
//
//    }
}
