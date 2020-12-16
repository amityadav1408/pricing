package com.pricing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricing.dto.PricingDto;
import com.pricing.model.Account;
import com.pricing.model.AcctPrdtPriceRel;
import com.pricing.model.CustPrdtPriceRel;
import com.pricing.model.Customer;
import com.pricing.model.ProductPricing;
import com.pricing.repository.AccountRepository;
import com.pricing.repository.AcctPrdtPriceRelRepository;
import com.pricing.repository.CustPrdtPriceRelRepository;
import com.pricing.repository.CustomerRepository;
import com.pricing.repository.ProductPricingRepository;

@Service
public class PricingServiceImpl implements PricingService{

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ProductPricingRepository pricingRepository;

	@Autowired
	AcctPrdtPriceRelRepository acctPrdtPriceRelRepository;

	@Autowired
	CustPrdtPriceRelRepository custPrdtPriceRelRepository;



	public PricingDto getPrice(String globCustId, String acctNumber) {
		PricingDto pricingDto = new PricingDto();




		if(acctNumber == null) {
			List<ProductPricing> custPriceList = new ArrayList<>();

			Long custId = customerRepository.findByCustId(globCustId);

			Long custPrdctId = custPrdtPriceRelRepository.findByCustId(custId);

			custPriceList = pricingRepository.findByPrdtId(custPrdctId);

		}else {
			List<ProductPricing> acctPriceList = new ArrayList<>();

			Long acctId =	accountRepository.findByAcctNum(acctNumber);

			Long acctPrdctId = acctPrdtPriceRelRepository.findByAcctId(acctId);

			acctPriceList = pricingRepository.findByPrdtId(acctPrdctId);



		}




		return pricingDto ;
	}
}
