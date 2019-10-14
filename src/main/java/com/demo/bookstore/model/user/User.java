package com.demo.bookstore.model.user;

import java.util.Date;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	@Id
	private String username;
	private String password = "";
	private String firstName;
	private String lastName;
	private  Date   birthday ;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {
		
	}

	public User(String username, String password, String firstName, String lastName, Date date , Role role) {
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthday(date);
	}
	
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}
