package com.example.controller;

import com.example.model.Book;

import java.util.List;

public interface BookController {
    Iterable<Book> createBooks(List<Book> books);

    Iterable<Book> getAll();

    Iterable<Book> getByName(String name);

    Iterable<Book> getByNameAndAuthor(String name, String author);

    Iterable<Book> getByPrice(double price);

    Book createBooks(Book book);
}
