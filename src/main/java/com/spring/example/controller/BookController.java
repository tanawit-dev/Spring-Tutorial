/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.example.controller;

import com.spring.example.exception.BookNotFoundException;
import com.spring.example.model.Book;
import com.spring.example.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tanawit Aeabsakul
 */
@RestController
@RequestMapping("api/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;
    
    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    
    @GetMapping("title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable("bookTitle") String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }
    
    @GetMapping("/{id}")
    public Book findOne(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
    
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }
    
    
}
