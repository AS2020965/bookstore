package com.example.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Service.BookService;
import com.example.bookstore.Service.MyBookService;

//import ch.qos.logback.core.model.Model;

import com.example.bookstore.Entity.MyBookList;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookService myBookService;
	
	
	@GetMapping("/")
	public String home() {
		
		return "home";
		
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		
		return "bookRegister";
		
	}
	
	@GetMapping("/book_list")
	public ModelAndView bookList() {
		
		List<Book>list = bookService.getAllBook();
		
		return new ModelAndView("bookList","book",list);
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		
		bookService.save(book);
		return "redirect:/book_list";
		
		
	}
	
	@GetMapping("/my_book")
	public ModelAndView myBook() {
		
		List<MyBookList>list = myBookService.getAllBook();
		return new ModelAndView("myBook","myBook",list);
	}
	
	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		
		Book b = bookService.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBook(mb);
		return "redirect:/my_book";
		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBookList(@PathVariable("id") int id) {
		
		myBookService.deleteByid(id);
		return "redirect:/my_book";
	}
	
	@RequestMapping("/bookList/{id}")
	public String deleteByList(@PathVariable("id") int id) {
		
		bookService.deleteByid(id);
		return "redirect:/book_list";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		
		Book b = bookService.getBookById(id);
		model.addAttribute("book",b);
		
		return "bookEdit";
	}
	
	
	
	
	
	
	
	
	

}
