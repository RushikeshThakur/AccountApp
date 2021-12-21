package com.amdocs.accountsappliction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.accountsappliction.helperobject.ResponseMessage;
import com.amdocs.accountsappliction.pojo.Accounts;
import com.amdocs.accountsappliction.pojo.Users;
import com.amdocs.accountsappliction.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/feign/create")
	public ResponseMessage saveAccount(@RequestBody Users user) {
		ResponseMessage response = accountService.saveAccount(user);
		if(response.isSuccess()) {
			return response;
		}
		return response;
	}
	
	@GetMapping("/feign/get/{userID}")
	public ResponseMessage getAccount(@PathVariable int userID) {
		ResponseMessage response = accountService.getAccount(userID);
		if(response.isSuccess()) {
			return response;
		}
		return response;
	}
	
	@PutMapping("/feign/update/{userID}")
	public ResponseMessage updateAccount(@RequestBody Users user, @PathVariable int userID) {
		ResponseMessage response = accountService.updateAccount(user, userID);
		if(response.isSuccess()) {
			return response;
		}
		return response;
	}
	
	@PutMapping("/feign/account/update/{accountID}")
	public ResponseMessage updateSingleAccount(@RequestBody Accounts account, @PathVariable int accountID) {
		ResponseMessage response = accountService.updateSingleAccount(account, accountID);
		if(response.isSuccess()) {
			return response;
		}
		return response;
	}
	
	@DeleteMapping("/feign/delete/{userID}")
	public ResponseMessage deleteAccount(@PathVariable int userID) {
		ResponseMessage response = accountService.deleteAccount(userID);
		if(response.isSuccess()) {
			return response;
		}
		return response;
	}
	
	@DeleteMapping("/feign/single/delete/{accountID}")
	public ResponseMessage deleteSingleAccount(@PathVariable int accountID) {
		ResponseMessage response = accountService.deleteSingleAccount(accountID);
		if(response.isSuccess()) {
			return response;
		}
		return response;
	}
	
	
}
