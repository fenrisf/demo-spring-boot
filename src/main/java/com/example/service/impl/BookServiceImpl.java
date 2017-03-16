package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import com.example.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository repository;
    private NotificationService notificationService;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookServiceImpl(BookRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @Override
    public Iterable<Book> findByName(String name) {
        return repository.findByName(name);
    }
    @Override
    public Iterable<Book> findAll() {
        return repository.findAll();
    }
    @Override
    public Book addBook(Book book) {
        //Mandamos una notificación con el Libro añadido
        NotificationServiceImpl.NotificationDef definition = notificationService.getNotificationDefBuilder().withTo("").build();
        if(!notificationService.sendNotification(definition)){
            logger.warn("No se ha prodido mandar la notificación.");
        }

        return repository.save(book);
    }
    @Override
    public Iterable<Book> addAll(Iterable<Book> books) {
        return repository.save(books);
    }
    @Override
    public Iterable<Book> findByNameAndAuthor(String name, String author) {
        return repository.findByNameAndAuthor(name, author);
    }
    @Override
    public Iterable<Book> findByPrice(double price) {
        return repository.findByPrice(price);
    }
}
