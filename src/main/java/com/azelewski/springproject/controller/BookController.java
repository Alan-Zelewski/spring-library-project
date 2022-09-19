package com.azelewski.springproject.controller;

import com.azelewski.springproject.model.Book;
import com.azelewski.springproject.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view-books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/books")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "/list-books";
    }
}