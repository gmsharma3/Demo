package com.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Book;
import com.spring.service.ListService;

@Controller
public class ListController {

	@Autowired
	private ListService listService;
	
	@RequestMapping("/listBooks")
	public ModelAndView getListOfBooks() {
		List<Book> books = new ArrayList<>();
		books = listService.getListOfBooksService();
		/*for (int i = 0; i < 10; i++) {
			Book book = new Book();
			book.setId(i);
			book.setName("book" + i);
			book.setPrice(i + "");
			Publisher publisher = new Publisher();
			publisher.setId(i);
			publisher.setName("publisher" + i);
			book.setPublisher(publisher);
			books.add(book);
		}*/
		ModelAndView view = new ModelAndView("bookList");
		view.addObject("books", books);
		return view;
	}

	@RequestMapping("/form.htm")
	public String getForm(Model model) {
		Book book = new Book();
		model.addAttribute("bookForm", book);
		return "bookSearch";
	}
	
	@RequestMapping("/search.htm")
	public ModelAndView getBook(Book book) {
		List<Book> books = null;
		ModelAndView view = new ModelAndView("bookList");
		books = listService.getListOfBooksService(book.getId());
		view.addObject("books", books);
		return view;
	}
	
}
