package com.newrishman;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newrishman.controllers.BookController;
import com.newrishman.domain.Book;
import com.newrishman.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService service;

    @Test
    public void saveBookTest() throws Exception {

    }

    @Test
    public void updateBookTest() throws Exception {

    }

    @Test
    public void findAllBooksTest() throws Exception {

        List<Book> books = Arrays.asList(new Book(), new Book(), new Book());

        given(service.findAll()).willReturn(books);

        mvc.perform(get("/books")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(books.size())));
    }

    @Test
    public void getBookByIdTest() throws Exception {
        Book book = new Book(1, "A1", "B1", 10);
        when(service.getBookById(1)).thenReturn(book);

        mvc.perform(get("/books/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("bookName").value(book.getBookName()));
    }

    @Test
    public void deleteBookTest() throws Exception {
        mvc.perform(delete("/books/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
