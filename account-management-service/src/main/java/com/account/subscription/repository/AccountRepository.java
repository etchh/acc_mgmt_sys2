package com.account.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.account.subscription.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	
	@Query("SELECT count(*) from Account")
	public int countAccounts();
	
	public Account findByAccountName(String accountName);

}
