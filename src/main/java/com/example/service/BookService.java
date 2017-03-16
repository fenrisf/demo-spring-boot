package com.example.service;

import com.example.model.Book;

/**
 * Created by albertomartinez on 15/03/17.
 */
public interface BookService {
    Iterable<Book> findByName(String name);

    Iterable<Book> findAll();

    Book addBook(Book book);

    Iterable<Book> addAll(Iterable<Book> books);

    Iterable<Book> findByNameAndAuthor(String name, String author);

    Iterable<Book> findByPrice(double price);
}
