package com.newrishman.controllers;

import com.newrishman.domain.Book;
import com.newrishman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private BookService service;

    @Autowired
    public void setBookService(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public String books (Model model) {
        List<Book> books = service.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/save")
    public String updateBook(@RequestParam String bookName, @RequestParam String bookAuthor, @RequestParam int price) {
        service.saveBook(new Book(bookName, bookAuthor, price));
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book book = service.getBookById(id);
        model.addAttribute("note", book);
        return "/edit";
    }

    @PostMapping("/update")
    public String saveNote(@RequestParam Long id, @RequestParam String bookName,
                           @RequestParam String bookAuthor, @RequestParam int price) {
        service.updateBook(id, bookName, bookAuthor, price);
        return "redirect:/";}

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/";
    }

}

