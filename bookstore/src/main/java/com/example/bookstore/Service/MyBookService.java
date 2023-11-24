package com.example.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Entity.MyBookList;
import com.example.bookstore.Repositry.MyBookRepo;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepo myBookRepo;
	
	
	public void saveMyBook(MyBookList book) {
		
		myBookRepo.save(book);
	}
	
    public List<MyBookList> getAllBook(){
		
		return myBookRepo.findAll();
	}
    
    public void deleteByid(int id) {
    	
    	myBookRepo.deleteById(id);
    	
    	
    }

}
