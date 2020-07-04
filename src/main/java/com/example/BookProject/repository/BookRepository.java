package com.example.BookProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookProject.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
