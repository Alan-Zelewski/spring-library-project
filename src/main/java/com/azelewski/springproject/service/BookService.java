package com.azelewski.springproject.service;

import com.azelewski.springproject.model.Book;
import com.azelewski.springproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }else {
            throw new RuntimeException("Book of Id " + id + " not found");
        }
    }
}
