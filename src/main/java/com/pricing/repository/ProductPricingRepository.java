package com.pricing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pricing.model.ProductPricing;

public interface ProductPricingRepository extends JpaRepository<ProductPricing , Long>{


}


