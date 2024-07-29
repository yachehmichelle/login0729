package com.systex.project.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systex.project.model.Account;
import com.systex.project.model.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	  public boolean checkAccuunt(Account account) {
		  Optional<Account> ac=accountRepository.findById(account.getUsername());
		  if (ac.isEmpty()) {
			  return false;
		  }
		  
	      return account.getPassword().equals(ac.get().getPassword());
	    }
	
}
