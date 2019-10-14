package com.demo.bookstore.service.daoservice;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.bookstore.model.Book;
import com.demo.bookstore.model.order.OrderBook;
import com.demo.bookstore.model.order.OrderRequest;
import com.demo.bookstore.repo.OrderRepository;

@Repository
@Transactional
public class OrderDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private OrderRepository orderRepository;

	public void insert(String username, int bookId) {

			OrderBook order = new OrderBook();
			order.setBookid(bookId);
			order.setUsername(username);
			entityManager.persist(order);
	}

	public List<OrderBook> findByUsername(String username) {
		List<OrderBook> listOrder = orderRepository.findByUsername(username);
		return listOrder;

	}
	public void removeByUsername(String username) {
		List<OrderBook> listOrder = orderRepository.findByUsername(username);
		orderRepository.deleteAll(listOrder);

	}

}
