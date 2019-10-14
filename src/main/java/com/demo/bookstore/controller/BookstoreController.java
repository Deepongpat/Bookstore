package com.demo.bookstore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookstore.model.Book;
import com.demo.bookstore.service.daoservice.BookDAOService;


@RestController
public class BookstoreController {
	
	@Autowired
	private BookDAOService bookDaoService;
	
	@RequestMapping({ "/api/orderBook" })
	public String orderBook() {
		return "Hello World";
	}
	@RequestMapping(value = "/books", method = RequestMethod.GET )
	@ResponseBody
	public Collection<Book> Books() throws Exception  {
		
		try {
			return  bookDaoService.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
