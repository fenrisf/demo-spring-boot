package com.example.repository;

import com.example.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * Created by albertomartinez on 9/03/17.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long>{
    Iterable<Book> findByName(String name);
    Iterable<Book> findByAuthor(String author);
    Iterable<Book> findByPrice(double price);
    Iterable<Book> findByNameAndAuthor(String name, String author);
}
