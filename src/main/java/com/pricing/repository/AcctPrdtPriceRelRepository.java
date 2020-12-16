package com.pricing.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.AcctPrdtPriceRel;


public interface AcctPrdtPriceRelRepository extends JpaRepository<AcctPrdtPriceRel , Long>{

	@Query("select a.prdtId from AcctPrdtPriceRel a where a.account.acctId =: acctId")
	  Long  findByAcctId(@Param("acctId") Long acctId);
}


