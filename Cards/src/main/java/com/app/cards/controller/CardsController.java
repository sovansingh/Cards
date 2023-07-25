package com.app.cards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.app.cards.entity.CardConfigServer;
import com.app.cards.entity.Cards;
import com.app.cards.entity.Customer;
import com.app.cards.entity.Properties;
import com.app.cards.repository.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class CardsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardsController.class);
	
	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardConfigServer cardConfigServer;
	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationid,@RequestBody Customer customer){
		LOGGER.info("getCardDetails() method started");
		List<Cards> list = cardRepository.findByCustomerId(customer.getCustomerId());
		LOGGER.info("getCardDetails() method ended");
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	@GetMapping(value = "/cards/properties")
	public String getPropertyDetails()throws JsonProcessingException{
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(cardConfigServer.getMsg(), cardConfigServer.getBuildversion(), cardConfigServer.getMailDetails(), cardConfigServer.getActiveBranches());
		String strString = objectWriter.writeValueAsString(properties);
		return strString;
	
	}
}
