package com.newrishman;

import com.newrishman.domain.Book;
import com.newrishman.repository.BookRepository;
import com.newrishman.service.BookService;
import com.newrishman.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
public class BookServiceImplTest {
    @TestConfiguration
    static class BookServiceImplTestContextConfiguration {

        @Bean
        public BookService bookService() {
            return new BookServiceImpl();
        }
    }

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Before
    public void beforeTest() {
        Book books = new Book(1, "A1", "B2", 1);

        Mockito.when(bookRepository.getOne(books.getId())).thenReturn(books);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        long id = 1;
        Book found = bookService.getBookById(id);
        assertEquals(found.getId(), id);
    }


}
