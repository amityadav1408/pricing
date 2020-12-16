package com.pricing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricing.dto.PricingDto;
import com.pricing.model.Account;
import com.pricing.model.AcctPrdtPriceRel;
import com.pricing.model.CustPrdtPriceRel;
import com.pricing.model.Customer;
import com.pricing.model.ProductPricing;
import com.pricing.repository.AccountRepository;
import com.pricing.repository.AcctPrdPriceRelRepository;
import com.pricing.repository.CustPrdPriceRelRepository;
import com.pricing.repository.CustomerRepository;
import com.pricing.repository.ProductPricingRepository;

@Service
public class PricingServiceImpl implements PricingService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ProductPricingRepository pricingRepository;

	@Autowired
	CustPrdPriceRelRepository custPrdPriceRelRepository;

	@Autowired
	AcctPrdPriceRelRepository acctPrdPriceRelRepository;

	/*
	 * @Autowired AcctPrdtPriceRelRepository acctPrdtPriceRelRepository;
	 * 
	 * @Autowired CustPrdtPriceRelRepository custPrdtPriceRelRepository;
	 */

	public List<PricingDto> getPrice(String globCustId, String acctNumber) {

		List<PricingDto> pricingDtoList = new ArrayList<>();

		if (globCustId != null) {
			List<ProductPricing> custPriceList = new ArrayList<>();

			List<Customer> customer = customerRepository.findByCustId(globCustId);

			if(customer.isEmpty())
				return null;
			// Long custPrdctId = customer.getPrdcFtPricing().getProductId();
			List<CustPrdtPriceRel> customerPrdPrceRealtionList = custPrdPriceRelRepository
					.findByCustomerId(customer.stream().map(Customer::getCustId).collect(Collectors.toList()));

			for (CustPrdtPriceRel custPrdtPriceRel : customerPrdPrceRealtionList) {
				custPriceList = pricingRepository.findByPrdtId(custPrdtPriceRel.getPrdtId());
				for (ProductPricing productPricing : custPriceList) {
					PricingDto p = new PricingDto(globCustId,
							customer.get(0)!=null	&& customer.get(0).getAcctList()!=null && customer.get(0).getAcctList().get(0).getAcctNumber()!=null?customer.get(0).getAcctList().get(0).getAcctNumber():null, productPricing.getProductCd(),
							productPricing.getProductDesc(), productPricing.getProductGroup(),
							productPricing.getProductCtgry(), productPricing.getPricingCcy(),
							productPricing.getPricingType(), String.valueOf(productPricing.getPrice()));
					pricingDtoList.add(p);
				}
			}

			return pricingDtoList;

		} else if (acctNumber != null) {

			List<ProductPricing> acctPriceList = new ArrayList<>();

			List<Account> account = accountRepository.findByAcctNumber(acctNumber);

			List<AcctPrdtPriceRel> acctProdPriceRelList = acctPrdPriceRelRepository
					.findbyAcctId(account.stream().map(Account::getAcctId).collect(Collectors.toList()));
			
			List<Long> prodIdList = acctProdPriceRelList.stream().map(AcctPrdtPriceRel::getPrdtId)
					.collect(Collectors.toList());

			// acctPriceList = pricingRepository.findByPrdtId(prodIdList);
			acctPriceList = pricingRepository.findByProductIds(prodIdList);
			for (ProductPricing productPricing : acctPriceList) {
				PricingDto p = new PricingDto(null, acctNumber, productPricing.getProductCd(),
						productPricing.getProductDesc(), productPricing.getProductGroup(),
						productPricing.getProductCtgry(), productPricing.getPricingCcy(),
						productPricing.getPricingType(), String.valueOf(productPricing.getPrice()));
				pricingDtoList.add(p);
			}

			return pricingDtoList;

		} else {

			List<Customer> cust = customerRepository.findAll();

			System.out.println("cust ID :" + cust.get(0).getGlobCustId() + "acct No :"
					+ cust.get(0).getAcctList().get(0).getAcctNumber());
			return pricingDtoList;
		}

	}
}
