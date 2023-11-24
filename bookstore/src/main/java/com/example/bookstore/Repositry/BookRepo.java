package com.example.bookstore.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
	

}
