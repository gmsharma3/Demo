package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ListDao;
import com.spring.model.Book;

@Service
public class ListService {

	
	@Autowired
	private ListDao listDao;
	
	public List<Book> getListOfBooksService() {
		return listDao.getListOfBooks();
	}
	
	public List<Book> getListOfBooksService(int id) {
		return listDao.getListOfBooks(id);
	}
	
}
