package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Product;

import jakarta.persistence.Entity;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	
}
