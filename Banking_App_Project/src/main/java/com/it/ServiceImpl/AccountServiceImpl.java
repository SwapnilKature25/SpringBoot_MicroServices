package com.it.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.it.dto.AccountDto;
import com.it.entity.Account;
import com.it.mapper.AccountMapper;
import com.it.repository.AccountRepository;
import com.it.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService
{
	
	private AccountRepository accRepository;

	
	
	public AccountServiceImpl(AccountRepository accRepository) {
		super();
		this.accRepository = accRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accRepository
				.findById(id)
				.orElseThrow( ()-> new RuntimeException("Account does not exists"));
		return AccountMapper.mapToAccountDto(account);
	}
	
	@Override
	public AccountDto getAllAccounts() {
		List<Account> findAll = accRepository.findAll();
		return AccountMapper.mapToAccountDto(findAll);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accRepository
				.findById(id)
				.orElseThrow( ()-> new RuntimeException("Account does not exists"));
		double total = account.getBalance()+amount;
		account.setBalance(total);
		Account saveAccount = accRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);

	}

	

	
}
