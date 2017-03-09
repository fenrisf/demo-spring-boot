package com.example.controller.impl;

import com.example.controller.BookController;
import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookControllerImpl implements BookController {
    private BookService bookService;

    @Autowired
    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Book createBooks(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.PUT)
    public Iterable<Book> createBooks(@RequestBody List<Book> books) {
        return bookService.addAll(books);
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Book> getAll() {
        return bookService.findAll();
    }

    @Override
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Iterable<Book> getByName(@PathVariable(name = "name") String name) {
        return bookService.findByName(name);
    }

    @Override
    @RequestMapping(value = "/name/{name}/author/{author}", method = RequestMethod.GET)
    public Iterable<Book> getByNameAndAuthor(@PathVariable(name = "name") String name, @PathVariable(name = "author") String author) {
        return bookService.findByNameAndAuthor(name, author);
    }

    @Override
    @RequestMapping(value = "/price/{price}", method = RequestMethod.GET)
    public Iterable<Book> getByPrice(@PathVariable(name = "price") double price) {
        return bookService.findByPrice(price);
    }
}
