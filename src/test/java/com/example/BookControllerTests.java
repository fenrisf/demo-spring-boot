package com.example;

import com.example.controller.BookController;
import com.example.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTests {
    @Autowired
    private BookController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private List<Book> books;

    @Before
    public void init(){
        Book auxBook = new Book("Book 1", "author1", 10D);
        books.add(auxBook);
        auxBook = new Book("Book 2", "author2", 15D);
        books.add(auxBook);
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnEmptyBookListWithNoData() throws Exception {
        ResponseEntity<Iterable> response = this.restTemplate.getForEntity("/book/", Iterable.class);
        Iterable<Book> bookList = response.getBody();
        assertThat(bookList).isEmpty();
    }

    @Test
    public void shouldReturnABookAfterAdded() throws Exception {
        this.restTemplate.put("/book/all", books);
        ResponseEntity<Iterable> response = this.restTemplate.getForEntity("/book/", Iterable.class);
        Iterable<Book> bookList = response.getBody();
        assertThat(bookList).isNotEmpty();
        assertThat(bookList).contains(books.get(0));
    }

}
