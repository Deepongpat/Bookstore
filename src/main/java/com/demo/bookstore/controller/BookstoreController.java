package com.demo.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookstoreController {
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

}
