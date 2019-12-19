/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.example.repository;

import com.spring.example.model.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Tanawit Aeabsakul
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitle(String title);
}
