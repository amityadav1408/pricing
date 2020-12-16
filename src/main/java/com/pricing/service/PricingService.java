package com.pricing.service;

import java.util.List;

import com.pricing.dto.PricingDto;

public interface PricingService {

		List<PricingDto> getPrice(String custId, String acctNumber);
}
