package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer>
{
	
}
