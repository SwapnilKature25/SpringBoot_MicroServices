package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>
{

}
