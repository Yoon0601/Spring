package com.hello.service;

import com.hello.dto.Book;
import com.hello.entity.BookEntity;
import com.hello.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
public class BookService {
    private BookRepository bookRepository ;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Transactional
    public Book createBook(Book book) {
        Book result = bookRepository.save(book.toEntity()).toDto();
        return result;
    }

    @Transactional
    public Book getBook(Long id) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(()->new NullPointerException("id에 맞는 값이 없습니다."));
        return entity.toDto();
    }

    @Transactional
    public BookEntity updateBook(Book book,Long id){
        BookEntity result = bookRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("수정할 대상이 없습니다."));
        result.updatebook(book);
        return bookRepository.save(result);


    }
    @Transactional
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}

