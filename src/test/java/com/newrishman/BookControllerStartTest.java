package com.newrishman;

import static org.assertj.core.api.Assertions.assertThat;

import com.newrishman.controllers.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerStartTest {

    @Autowired
    private BookController controller;

    @Test
    public void bookControllerSimpleTest() throws Exception {
        assertThat(controller).isNotNull();
    }
}