package com.hello;

import lombok.*;

import java.sql.Timestamp;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Book {
    String title;
    int price;
    String author;
    String publisher;
//    Timestamp r_time;
//    Timestamp m_time;
}
