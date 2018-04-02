package com.account.subscription.component;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.account.subscription.entity.Account;
import com.account.subscription.repository.AccountRepository;

@Component
public class AccountComponent {
	private static final Logger logger = LoggerFactory.getLogger(AccountComponent.class);

//	@Autowired
	AccountRepository accountRepository;

	public AccountComponent() {
		System.out.println("*******Component***********");
	}

	@Autowired
	AccountComponent(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	@Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		
		logger.info("AccountRepository says system has "
				+ accountRepository.countAccounts() + " accounts");
	}

	/**
	 * Account Sign Up (Registration)
	 */
	public String addAccount(Account account) {
		logger.info("Saving Account ");
		accountRepository.save(account);
		logger.info("Successfully saved Account ");

		return "Saved";

	}

	/**
	 * View Account’s profile
	 */
	public Account getAccountRecordByID(long id) {
		Optional<Account> accountObject = accountRepository.findById(id);
		return accountObject.get();
	}
	
	public Account getAccountRecordByAccountName(String accountName) {
		
		Account accountObject = accountRepository.findByAccountName(accountName);
		
		return accountObject;
	}

	/**
	 * get all account
	 */
	public Iterable<Account> getAllAccounts() {
		// This returns a JSON or XML with the account
		return accountRepository.findAll();
	}

	// Edit account data
	public String updateAccountData(Account account) {
		logger.info("Account to be updated ..."+ account.getEmail());
		
		accountRepository.save(account);
		logger.info("Successfully Updated the Account ");

		return "Updated";

	}

}
