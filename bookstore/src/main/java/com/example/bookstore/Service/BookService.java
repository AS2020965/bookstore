package com.example.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Repositry.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public void save(Book book) {
		
		bookRepo.save(book);
	}
	
	public List<Book> getAllBook(){
		
		return bookRepo.findAll();
	}
	
    public Book getBookById(int id) {
		
    	
		return bookRepo.findById(id).get();
		
		
	}
    
    public void deleteByid(int id) {
    	
    	bookRepo.deleteById(id);
    	
    	
    }

}
