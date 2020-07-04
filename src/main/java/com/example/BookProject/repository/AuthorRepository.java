package com.example.BookProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookProject.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
