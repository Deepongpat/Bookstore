package com.demo.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookstore.model.Book;
import com.demo.bookstore.model.order.OrderRequest;
import com.demo.bookstore.model.order.OrderResponse;
import com.demo.bookstore.service.daoservice.BookDAOService;
import com.demo.bookstore.service.daoservice.OrderDAOService;

@RestController
public class OrderController {

	@Autowired
	private OrderDAOService orderDaoService;
	@Autowired
	private BookDAOService bookDAOService;

	@RequestMapping(value = "/addOrders", method = RequestMethod.POST)
	@ResponseBody
	public OrderResponse addOrder(@RequestBody OrderRequest order) {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String username = userDetails.getUsername();

			double price = 0;
			for (int BookId : order.getOrders()) {
				// findBookByID
				Book book = bookDAOService.findById(BookId);
				if (book != null) {
					price = price + book.getPrice();
					orderDaoService.insert(username, BookId);
				}

			}
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setPrice(price);
			return orderResponse;
		} catch (Exception e) {
			return null;
		}
	}

}
