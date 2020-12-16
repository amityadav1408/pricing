package com.pricing.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.Account;


public interface AccountRepository extends JpaRepository<Account , Long>{

	
	  @Query("select a from Acccount a where a.acctNumber =: acctNumber")
	  List<Account> findByAcctNum(@Param("acctNumber") String acctNumber);
	  

}


