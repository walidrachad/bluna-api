package com.vaibhav.sec.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.sec.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
	Optional<User> findByUsernameOrEmail(String username, String email);
	User findByIdIn(Long userIds);
	User findByUsername(String username);
	Boolean existsByUsername(String username);
    User getByEmail(String email);
	Boolean existsByEmail(String email);
}
