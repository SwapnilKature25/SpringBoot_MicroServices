package com.it.mapper;

import com.it.dto.AccountDto;
import com.it.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accDto) {
		Account account=new Account(
				accDto.getId(),
				accDto.getAccountHolderName(),
				accDto.getBalance()
		);
		
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accDto=new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
		);
		return accDto;
	}
	
}
