package com.amudhan.practice.customers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@PersistenceContext
	private EntityManager entityManager;
	protected static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value="/customer", method = RequestMethod.GET)
	@Transactional
	public Customer greet(@RequestParam(value = "customerId", defaultValue = "World") long id)	{
		Customer customer = entityManager.find(Customer.class, id);
		logger.info(customer+"");
		return customer;
	}

}
