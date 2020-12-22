package com.pricing.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.dto.PricingDto;


@RestController
public interface PricingController {


	@GetMapping("/pricing")
	ResponseEntity<List<PricingDto>> getPrice(
			@RequestParam(required = false) String glbCustId,
			@RequestParam(required = false) String acctNumber);


}
