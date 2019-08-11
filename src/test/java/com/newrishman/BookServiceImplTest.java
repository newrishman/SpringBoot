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
        Book books = new Book(1, "A1", "B1", 1);

        Mockito.when(bookRepository.getOne(books.getId())).thenReturn(books);
    }

    @Test
    public void getBookByIdTest() {
        long id = 1;
        bookService.getBookById(id);
        Mockito.verify(bookRepository, times(1)).getOne(id);
    }

    @Test
    public void saveBookTest() {
        Book bookSave = new Book(1, "A3", "B3", 100);
        bookService.saveBook(bookSave);
        Mockito.verify(bookRepository, times(1)).save(bookSave);
    }

    @Test
    public void updateBookTest() {
        Book bookUpdate = new Book(1, "A3", "B3", 100);
        long id = 1;
        bookService.updateBook(bookUpdate);
        Mockito.verify(bookRepository, times(1)).getOne(id);
        Book book = bookRepository.getOne(id);
        Mockito.verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void deleteBookTest() {
        long id = 1;
        bookService.deleteBook(id);
        Mockito.verify(bookRepository, times(1)).deleteById(id);
    }

    @Test
    public void findAllBooksTest() {
        bookService.findAll();
        Mockito.verify(bookRepository, times(1)).findAll();
    }
}
