package com.demo.bookstore.service.commandlinerunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.bookstore.model.user.Role;
import com.demo.bookstore.model.user.User;
import com.demo.bookstore.repo.UserRepository;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("1990-10-15");
		User user = new User("demo", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6","Pongpat", "Jantanon", myDate ,Role.USER);
		userRepository.save(user);
		log.info("New User is created : " + user);
		
	}
	
}