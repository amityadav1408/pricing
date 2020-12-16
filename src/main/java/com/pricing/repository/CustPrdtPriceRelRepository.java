package com.pricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.CustPrdtPriceRel;


public interface CustPrdtPriceRelRepository extends JpaRepository<CustPrdtPriceRel , Long>{


	@Query("select a from CustPrdtPriceRel a where a.glob_cud_id =: glbCustId")
	  List<CustPrdtPriceRel> findByCustId(@Param("glbCustId") String glbCustId);
}


