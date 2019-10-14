package com.demo.bookstore.service.daoservice;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.bookstore.model.Book;
import com.demo.bookstore.model.user.User;

@Repository
@Transactional
public class BookDAOService {

	@PersistenceContext
	private EntityManager entityManager;

	public Collection<Book> findAll() {
		String condition = "SELECT b FROM Book b WHERE b.isRecommended = true ORDER BY  b.bookName ";
		Query query = entityManager.createQuery(condition);
		
		String condition2 = "SELECT b FROM Book b WHERE b.isRecommended = false ORDER BY  b.bookName ";
		Query query2 = entityManager.createQuery(condition2);
		
		Collection<Book> listBook = query.getResultList();
		listBook.addAll( query2.getResultList());
		
		return  listBook;
		
	}
	public Book findById(int bookId) {
		long id = bookId;
		Book book = entityManager.find(Book.class,id);
		if (book != null) {
			return book;
		}
		return null;
	}
	

}
