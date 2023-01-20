package com.hello.controller;

import com.hello.dto.Book;
import com.hello.dto.ResponseDTO;
import com.hello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    /**
     * GET 메소드로 쿼리 파라미터를 입력해 값을 받음
     */
    @RequestMapping(value="/book/dto",method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Book requestParam(@RequestParam String title, @RequestParam int price,
                             @RequestParam String author, @RequestParam String publisher){
        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        book.setAuthor(author);
        book.setPublisher(publisher);
        return book;
    }

    /**
     *책을 생성하는 메서드 Book을 DB에 저장
     */
    @PutMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return book;
    }

    /**
     * GET 메소드로 DB에 있는 기본키로 조회해 정보를 받아옴
     */
    @GetMapping("/book/{pk}")
    public ResponseEntity<ResponseDTO> getBook(@PathVariable Long pk) {
        ResponseDTO responseDTO = new ResponseDTO();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        try {
            Book book = bookService.getBook(pk);
            responseDTO.setStatusCode(ResponseDTO.StatusEnum.OK);
            responseDTO.setMessage("성공");
            responseDTO.setData(book);
            return new ResponseEntity<>(responseDTO, headers, HttpStatus.OK);
        } catch (NullPointerException e) {
            responseDTO.setStatusCode((ResponseDTO.StatusEnum.NOT_FOUND));
            responseDTO.setMessage("id 값 찾기 실패");
            responseDTO.setData(e.getMessage());
            return new ResponseEntity<>(responseDTO, headers, HttpStatus.NOT_FOUND);
        }
    }

    /**
     *요청 메시지 바디로 기본키로 조회한 정보를 수정한다.
     */
    @PutMapping("/book/{pk}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable Long pk,@RequestBody Book book){
        bookService.updateBook(book,pk);
        return book;
    }

    /**
     *기본키를 이용해 데이터 삭제
     */
    @DeleteMapping("/book/{pk}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long pk){
        bookService.deleteBook(pk);
    }

}