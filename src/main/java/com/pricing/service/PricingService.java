package com.pricing.service;

import com.pricing.dto.PricingDto;

public interface PricingService {

		PricingDto getPrice(String custId, String acctNumber);
}
