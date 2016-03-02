package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.model.Book;
import com.spring.model.Publisher;

@Repository
public class ListDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Book> getListOfBooks() {
		List<Book> books = null;
		books = jdbcTemplate
				.query("select book.id bookId, book.name, book.price,publisher.id publisherId,publisher.name publisherName from BOOK book, PUBLISHER publisher where book.id = publisher.id",
						new RowMapper<Book>() {

							@Override
							public Book mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								Book book = new Book();
								book.setId(Integer.parseInt(rs
										.getString("bookId")));
								book.setName(rs.getString("name"));
								book.setPrice(rs.getString("price"));
								Publisher publisher = new Publisher();
								publisher.setId(rs.getInt("publisherId"));
								publisher.setName(rs.getString("publisherName"));
								book.setPublisher(publisher);
								return book;
							}

						});
		return books;
	}
	
	public List<Book> getListOfBooks(int id) {
		List<Book> books = null;
		books = jdbcTemplate
				.query("select book.id bookId, book.name, book.price,publisher.id publisherId,publisher.name publisherName from BOOK book, PUBLISHER publisher where book.id = publisher.id and book.id = " + id,
						new RowMapper<Book>() {

							@Override
							public Book mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								Book book = new Book();
								book.setId(Integer.parseInt(rs
										.getString("bookId")));
								book.setName(rs.getString("name"));
								book.setPrice(rs.getString("price"));
								Publisher publisher = new Publisher();
								publisher.setId(rs.getInt("publisherId"));
								publisher.setName(rs.getString("publisherName"));
								book.setPublisher(publisher);
								return book;
							}

						});
		return books;
	}

}
