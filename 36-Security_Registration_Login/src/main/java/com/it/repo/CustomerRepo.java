package com.it.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer>
{
	public Customer findByCname(String cname);
}
