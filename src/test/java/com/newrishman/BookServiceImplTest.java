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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.internal.verification.VerificationModeFactory.times;


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
    public void getBookByIdTest() {
        long id = 1;
        Book found = bookService.getBookById(id);
        assertEquals(found.getId(), id);
    }

    @Test
    public void saveBookTest() {
        Book bookSave = new Book(2, "A2", "B2", 2);
        assertEquals(bookService.saveBook(bookSave), bookSave);
    }

    @Test
    public void updateBookTest() {
        long id = 1;
        int price = 100;
        Book bookUpdate = new Book(id, "A1", "B1", price);
        bookService.updateBook(bookUpdate);
        assertEquals(bookService.getBookById(id).getPrice(), price);
    }

    @Test
    public void deleteBookTest() throws Exception {
        long id = 1;
        bookService.deleteBook(id);
        Mockito.verify(bookRepository, times(1)).deleteById(eq(id));
    }

    @Test
    public void findAllBooksTest() {
        bookService.findAll();
        Mockito.verify(bookRepository, times(1)).findAll();
    }
}
