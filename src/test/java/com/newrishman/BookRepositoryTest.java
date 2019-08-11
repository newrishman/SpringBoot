package com.newrishman;

import com.newrishman.domain.Book;
import com.newrishman.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repo;

    @Test
    public void getBookByIdTest() {
        Book book = new Book("A1", "B1", 1);
        entityManager.persist(book);
        entityManager.flush();

        long id = 1;
        repo.findById(id);

        Book getBook = repo.getOne(book.getId());
        assertEquals(book.getId(), getBook.getId());
    }

    @Test
    public void saveBookTest() {
        Book bookSave = new Book("A2", "B2", 2);
        assertEquals(repo.save(bookSave), bookSave);
    }

    @Test
    public void updateBookTest() {
        long id = 1;
        int price = 100;
        Book book = new Book("A1", "B1", 1);
        entityManager.persist(book);
        entityManager.flush();

        Book bookUpdate = repo.getOne(id);
        bookUpdate.setPrice(price);
        assertEquals(repo.getOne(id).getPrice(), price);
    }

    @Test
    public void findAllBooksTest() {
        Book book = new Book("A1", "B1", 1);
        Book book2 = new Book("A2", "B2", 2);
        entityManager.persist(book);
        entityManager.persist(book2);
        entityManager.flush();

        Assert.assertEquals(repo.findAll().size(), 2);
    }

    @Test
    public void deleteBookTest() throws Exception {
        Book book = new Book("A1", "B1", 1);
        entityManager.persist(book);
        entityManager.flush();

        repo.deleteById(book.getId());
        assertTrue(repo.findAll().isEmpty());
        assertFalse(repo.findById(1L).isPresent());
    }
}
