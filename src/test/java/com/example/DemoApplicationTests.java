package com.example;

import com.example.controller.BookController;
import com.example.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
	@Autowired
	private BookController controller;

	@Autowired
	private TestRestTemplate restTemplate;

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

}
