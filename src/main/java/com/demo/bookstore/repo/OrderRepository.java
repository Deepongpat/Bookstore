package com.demo.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bookstore.model.order.OrderBook;




public interface OrderRepository extends JpaRepository<OrderBook, Long> {
	List<OrderBook> findByUsername(String username);
}