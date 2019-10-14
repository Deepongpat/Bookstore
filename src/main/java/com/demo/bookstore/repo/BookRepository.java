package com.demo.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}