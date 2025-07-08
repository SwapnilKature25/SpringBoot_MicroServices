package com.it.service;

import com.it.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto deposit(Long id, double amount);
	AccountDto getAllAccounts();
	
}
