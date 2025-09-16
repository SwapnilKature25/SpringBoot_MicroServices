package com.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
