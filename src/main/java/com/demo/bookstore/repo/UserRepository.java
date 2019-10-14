package com.demo.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.bookstore.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}
