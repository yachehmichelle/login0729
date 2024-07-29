package com.systex.project.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
//	@Query("SELECT a FROM Account a WHERE a.account = :account")
    Optional<Account> findById(String account);
	
	

}
