package com.pricing.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.dto.PricingDto;


@RestController
@RequestMapping(value = "/")
public interface PricingController {


	@GetMapping("/pricing")
	ResponseEntity<PricingDto> getPrice(
			@RequestParam(required = false) String custId,
			@RequestParam(required = false) String acctNumber);


}
