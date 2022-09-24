package com.azelewski.springproject.controller;

import com.azelewski.springproject.model.Book;
import com.azelewski.springproject.model.BookAvailability;

import com.azelewski.springproject.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/book-details")
    public String getBookDetails(@RequestParam("bookId") Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book-details";
    }
    @GetMapping("/search")
    public String searchBooks(@RequestParam("searchValue") String searchValue, Model model){
        List<Book> books = bookService.searchBooks(searchValue);
        model.addAttribute("books", books);
        return "/list-books";
    }
    @GetMapping("/add-book")
    public String addBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book-form";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/view-books/books";
    }
    @GetMapping("/update")
    public String update(@RequestParam("bookId") Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") Long id, Model model){
        bookService.deleteById(id);
        return "redirect:/view-books/books";
    }
}
