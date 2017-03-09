package com.example.controller;

import com.example.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface BookController {
    Iterable<Book> createBooks(List<Book> books);
    Iterable<Book> getAll();
    Iterable<Book> getByName(String name);
    Iterable<Book> getByNameAndAuthor(String name, String author);
    Iterable<Book> getByPrice(double price);
    Book createBooks(Book book);
}
