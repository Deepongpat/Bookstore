package com.demo.bookstore.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderBook {

	@Id
	@GeneratedValue
	private long id;
	
    private String username;
    private long bookid;
    
    public OrderBook() {
    	
    }
    
	public OrderBook( String username, long bookid) {
		super();
		this.username = username;
		this.bookid = bookid;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setBookid(long bookid) {
		this.bookid = bookid;
	}
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public long getBookid() {
		return bookid;
	}
	
    
}
