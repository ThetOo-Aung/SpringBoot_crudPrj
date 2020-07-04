package com.example.BookProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookProject.model.Type;


@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{

}
