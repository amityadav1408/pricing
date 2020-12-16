package com.pricing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.dto.PricingDto;
import com.pricing.service.PricingService;

@RestController
public class PricingControllerImpl implements PricingController{

	@Autowired
	private PricingService pricingService;
	
	public ResponseEntity<PricingDto> getPrice(@RequestParam(required = false) String custId,
			@RequestParam(required = false) String acctNumber){
		
		PricingDto pricingDto = null;
		
		pricingDto = pricingService.getPrice(custId, acctNumber);
		
		return ResponseEntity.ok(pricingDto);
		
	}
}
