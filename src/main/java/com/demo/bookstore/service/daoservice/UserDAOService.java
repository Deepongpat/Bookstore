package com.demo.bookstore.service.daoservice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.bookstore.model.user.User;

@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	

	public String insert(User user) {
		entityManager.persist(user);
		return user.getUsername();
	}

	public User findUser(String username) {
		User user = entityManager.find(User.class, username);
		if (user != null) {
			return user;
		}
		return null;
	}
	
	public void delete(String username) {
		User user = entityManager.find(User.class, username);
		if (user != null) {
			entityManager.remove(user);
			//Remove OrderBook
			
		}
	}

}
