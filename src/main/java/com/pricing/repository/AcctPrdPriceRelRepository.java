package com.pricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.AcctPrdtPriceRel;
import com.pricing.model.Customer;

public interface AcctPrdPriceRelRepository extends JpaRepository<AcctPrdtPriceRel, Long> {

	@Query("select a from Customer a where a.globCustId = :globCustId")
	Customer findByCustId(@Param("globCustId") String globCustId);

	@Query("select a from AcctPrdtPriceRel a where a.acctId IN :acctIdList")
	List<AcctPrdtPriceRel> findbyAcctId(@Param("acctIdList") List<Long> acctIdList);

}
