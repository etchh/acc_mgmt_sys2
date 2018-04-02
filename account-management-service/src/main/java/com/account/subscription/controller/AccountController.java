package com.account.subscription.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.subscription.component.AccountComponent;
import com.account.subscription.entity.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	protected Logger logger = Logger.getLogger(AccountController.class
			.getName());

	AccountComponent accountComponent;

	@Autowired
	AccountController(AccountComponent accountComponent) {
		this.accountComponent = accountComponent;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String createParnter(@RequestBody Account accountRecord) {
		System.out.println("-----------Adding New Account--------");
		return accountComponent.addAccount(accountRecord);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Account> getAllAccounts() {
		// This returns a JSON or XML with the users
		return accountComponent.getAllAccounts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Account getAccountByID(@PathVariable long id) {
		// This returns a JSON or XML with the users
		return accountComponent.getAccountRecordByID(id);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody Account getAccountByID(@PathVariable String accountName) {
		// This returns a JSON or XML with the users
		return accountComponent.getAccountRecordByAccountName(accountName);
	}

	// Edit an Account by primary key
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	String updateAccount(@PathVariable long id) {
		// get that account
		return accountComponent.updateAccountData(accountComponent.getAccountRecordByID(id));
	}
	//

}
