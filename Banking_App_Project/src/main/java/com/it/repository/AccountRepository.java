package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.it.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>  // <entity class name, type of primary key >
{

}
