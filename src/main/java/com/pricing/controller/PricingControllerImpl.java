package com.pricing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.dto.PricingDto;
import com.pricing.service.PricingService;

@CrossOrigin
@RestController
public class PricingControllerImpl implements PricingController{

	@Autowired
	private PricingService pricingService;
	
	public ResponseEntity<List<PricingDto>> getPrice(@RequestParam(required = false) String glbCustId,
			@RequestParam(required = false) String acctNumber){
		
		List<PricingDto> pricingDto = new ArrayList<>();
		
		pricingDto = pricingService.getPrice(glbCustId, acctNumber);
		
		return ResponseEntity.ok(pricingDto);
		
	}
}
