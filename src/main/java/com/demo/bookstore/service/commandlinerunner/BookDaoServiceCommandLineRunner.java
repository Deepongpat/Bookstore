package com.demo.bookstore.service.commandlinerunner;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.bookstore.model.Book;
import com.demo.bookstore.repo.BookRepository;
import com.demo.bookstore.service.ExternalBookPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BookDaoServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	private static final Logger log = 
			LoggerFactory.getLogger(BookDaoServiceCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {

		// Add Book from Service

		try {
			ExternalBookPublisher externalBookPublisher = new ExternalBookPublisher();
			String jsonBook = externalBookPublisher.getBook();
			String jsonBookRecommend = externalBookPublisher.getBookRecommendation();
			//Book 
			ObjectMapper mapperBook = new ObjectMapper();
			List<Map<String, Object>> listBook = mapperBook.readValue(jsonBook, List.class);
			//BookRecommend
			ObjectMapper mapperBookRecommend = new ObjectMapper();
			List<Map<String, Object>> listBookRecommend = mapperBookRecommend.readValue(jsonBookRecommend, List.class);
			
			for (Map<String, Object> item : listBook) {
				Book book = new Book();
				book.setId(new Long((int) item.get("id")));
				book.setBookName((String) item.get("book_name"));
				Object obj = item.get("price");
				double price = 0.0;
				if(obj instanceof Integer) {
					 price = (int)item.get("price");
				}else if(obj instanceof Double) {
					 price = (double) item.get("price");
				}
				book.setPrice(price);
				book.setAuthorName((String) item.get("author_name"));
				
				//Set Recommended Book
				book.setRecommended(false);
				for (Map<String, Object> map : listBookRecommend) {
					int bookId = (int)item.get("id");
					int bookRecId = (int)map.get("id");
					if(bookId==bookRecId) {
						book.setRecommended(true);
					}
				}
				log.info("add book name : " + (String) item.get("book_name"));
				bookRepository.save(book);
			}
		} catch (Exception e) {
			log.error("error : " + e);
		}

	}
}
