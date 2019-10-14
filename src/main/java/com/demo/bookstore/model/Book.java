package com.demo.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private long id;
	private String bookName = "";
	private double price;
	private String authorName;
	private boolean isRecommended;

	public Book() {

	}

	public Book(long id, String bookName, double price, String authorName, boolean isRecommended) {
		super();
		this.setId(id);
		this.setBookName(bookName);
		this.setPrice(price);
		this.setAuthorName(authorName);
		this.setRecommended(isRecommended);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}


}
