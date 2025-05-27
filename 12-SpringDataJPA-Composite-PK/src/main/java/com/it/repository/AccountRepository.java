package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Account;
import com.it.entity.AccountPK;

public interface AccountRepository extends JpaRepository<Account,AccountPK>
{

}
