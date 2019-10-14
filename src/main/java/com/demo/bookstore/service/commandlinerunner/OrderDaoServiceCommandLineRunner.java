package com.demo.bookstore.service.commandlinerunner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.bookstore.model.order.OrderBook;
import com.demo.bookstore.repo.OrderRepository;



@Component
public class OrderDaoServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(OrderDaoServiceCommandLineRunner.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		OrderBook order = new OrderBook("test",1);
		orderRepository.save(order);
		log.info("New Order is created user : demo" );
	}
}