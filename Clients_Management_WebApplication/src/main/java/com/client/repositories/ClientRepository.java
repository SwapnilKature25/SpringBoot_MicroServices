package com.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.client.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	public Client findByEmail(String email);
}
