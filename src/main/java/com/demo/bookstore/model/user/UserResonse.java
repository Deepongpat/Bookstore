package com.demo.bookstore.model.user;

import java.util.ArrayList;

public class UserResonse {
	
	private String username;
	private String firstName;
	private String lastName;
	private String  birthday ;
	private ArrayList<Integer>  books = new ArrayList<>() ; 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public ArrayList<Integer> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Integer> books) {
		this.books = books;
	}


}
