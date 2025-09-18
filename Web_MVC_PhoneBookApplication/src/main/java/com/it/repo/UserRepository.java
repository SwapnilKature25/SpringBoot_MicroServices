package com.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
