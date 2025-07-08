package com.it.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.AccountDto;
import com.it.service.AccountService;

@RestController
@RequestMapping("/api/accounts")  // base url for all rest apis that we defined in this controller class
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	public AccountController() {
	}
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	 
	// Add account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accDto){
		return new ResponseEntity<>(accountService.createAccount(accDto), HttpStatus.CREATED);
	}
	
	public ResponseEntity<AccountDto> getAllAccounts(){
		AccountDto allAccounts = accountService.getAllAccounts();
		return ResponseEntity.ok(allAccounts);
	}
	
	// Get accept REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	
	// Deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
		 Double amount = request.get("amount");
		 AccountDto accountDto=accountService.deposit(id, amount);
		 return ResponseEntity.ok(accountDto);
	}
	
	
}
