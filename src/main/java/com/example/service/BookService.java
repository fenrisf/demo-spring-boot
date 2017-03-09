package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Iterable<Book> findByName(String name) {
        return repository.findByName(name);
    }

    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public Iterable<Book> addAll(Iterable<Book> books) {
        return repository.save(books);
    }

    public Iterable<Book> findByNameAndAuthor(String name, String author) {
        return repository.findByNameAndAuthor(name, author);
    }

    public Iterable<Book> findByPrice(double price) {
        return repository.findByPrice(price);
    }
}
