package com.example.BookProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookProject.model.Printing_Service;


@Repository
public interface PrintingServiceRepository extends JpaRepository<Printing_Service, Long>{

}
