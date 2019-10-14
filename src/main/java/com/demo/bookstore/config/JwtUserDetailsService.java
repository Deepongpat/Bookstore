package com.demo.bookstore.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.bookstore.repo.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			com.demo.bookstore.model.user.User user = userRepository.findOneByUsername(username);
			
			if(user!=null) {
				return new User(user.getUsername(),user.getPassword(),
						new ArrayList<>());
			 }else {
				 throw new UsernameNotFoundException("User not found with username: " + username);		 
			 }
			
		} catch (Exception e) {
			 throw new UsernameNotFoundException("User not found with username: " + username);		 
		}
	}

}