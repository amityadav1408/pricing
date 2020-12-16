package com.pricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.Account;
import com.pricing.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Long>{

	@Query("select a.custId from Customer a where a.globCustId =: globCustId")
	  Long findByCustId(@Param("globCustId") String globCustId);

}


