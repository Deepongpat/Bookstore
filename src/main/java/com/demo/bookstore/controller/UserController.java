package com.demo.bookstore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookstore.model.order.OrderBook;
import com.demo.bookstore.model.user.Role;
import com.demo.bookstore.model.user.User;
import com.demo.bookstore.model.user.UserRequest;
import com.demo.bookstore.model.user.UserResonse;
import com.demo.bookstore.service.daoservice.OrderDAOService;
import com.demo.bookstore.service.daoservice.UserDAOService;

@RestController
public class UserController {

	@Autowired
	private UserDAOService userDaoService;
	@Autowired
	private OrderDAOService orderDAOService;

	@RequestMapping({ "/getUser" })
	@ResponseBody
	public UserResonse getUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User user = userDaoService.findUser(username);
		UserResonse userResponse = new UserResonse();
		userResponse.setUsername(user.getUsername());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		userResponse.setBirthday(df.format(user.getBirthday()));
		List<OrderBook> orderBookList = orderDAOService.findByUsername(username);
		ArrayList<Integer> books = new ArrayList<Integer>();
		for (OrderBook orderBook : orderBookList) {
			books.add((int) orderBook.getBookid());
		}
		userResponse.setBooks(books);
		
		
		return userResponse;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUsre(@RequestBody UserRequest userRequest) {
		try {
			
			User userCreate = new User();
			userCreate.setUsername(userRequest.getUsername());
			userCreate.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
			userCreate.setFirstName(userRequest.getFirstName());
			userCreate.setLastName(userRequest.getLastName());
			Date myDate = new SimpleDateFormat("dd/MM/yyyy").parse(userRequest.getDate_of_birth());
			userCreate.setBirthday(myDate);
			userCreate.setRole(Role.USER);
			String username = userDaoService.insert(userCreate);
			return "Create User Success => Name :"+username;
		} catch (Exception e) {
			return "Create User fail ";
		}
		
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser() {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			userDaoService.delete(username);
			orderDAOService.removeByUsername(username);
			return "Remove User Success :"+username;
		} catch (Exception e) {
			return "Remove User fail ";
		}
		
		
	}

}
