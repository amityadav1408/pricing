package com.pricing.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.Account;


public interface AccountRepository extends JpaRepository<Account , Long>{

	
	
	  @Query("select a from Account a where a.acctNumber = :acctNumber")
	  List<Account> findByAcctNumber(@Param("acctNumber") String acctNumber, Pageable pageable);
	  
	 
	
	

}


