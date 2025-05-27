package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query(value="call getProducts()",nativeQuery=true )   // native Query
	public List<Product> getAllProducts();
}
