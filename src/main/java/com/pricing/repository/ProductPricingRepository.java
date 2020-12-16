package com.pricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pricing.model.CustPrdtPriceRel;
import com.pricing.model.ProductPricing;

public interface ProductPricingRepository extends JpaRepository<ProductPricing , Long>{

	@Query("select a from ProductPricing a where a.productId =: productId")
	  List<ProductPricing> findByPrdtId(@Param("productId") Long productId);
}


