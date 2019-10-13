package com.demo.bookstore.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@RequestMapping({ "/getUser" })
	public String getUser() {
		return "getUser";
	}
	@RequestMapping({ "/createUsre" })
	public String createUsre() {
		return "createUsre";
	}

	@RequestMapping({ "/deleteUser" })
	public String deleteUser() {
		return "deleteUser";
	}



}
