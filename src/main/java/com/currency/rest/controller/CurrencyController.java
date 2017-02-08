/**
 * 
 */
package com.currency.rest.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.currency.rest.model.CurrencyData;
import com.currency.rest.services.CurrencyService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Macbook pro This class is the front controller of the REST service.
 *         It handles all the requests and process it.
 */
@RestController
public class CurrencyController {

	Logger LOG = LoggerFactory.getLogger(CurrencyController.class);

	@Autowired
	CurrencyService currencyService;

	@RequestMapping(value = "/currency", method = RequestMethod.POST, headers = "Accept=application/json")
	public String postMessageToQueue(@RequestBody String string) {
		LOG.info("CurrencyController : postMessageToQueue : inside method");
		String result = "Curreny data added successfully";
		ObjectMapper mapper = new ObjectMapper();
		CurrencyData currencyData = null;
		try {
			currencyData = mapper.readValue(string, CurrencyData.class);
			LOG.info("CurrencyController : postMessageToQueue : currencyData {}", currencyData);
			if (null != currencyData) {
				// call the private method to produce the message to ActiveMQ
				currencyService.subbmitToQueue(currencyData);
			}
		} catch (JsonParseException e) {
			result = "not valid input - JsonParseException occurred";
			LOG.error("CurrencyController : postMessageToQueue : exception occured {}", e.getMessage());
		} catch (JsonMappingException e) {
			result = "not valid input - JsonMappingException occurred";
			LOG.error("CurrencyController : postMessageToQueue : exception occured {}", e.getMessage());
		} catch (IOException e) {
			result = "not valid input - IOException occurred";
			LOG.error("CurrencyController : postMessageToQueue : exception occured {}", e.getMessage());
		}
		LOG.info("CurrencyController : postMessageToQueue : result {}", result);
		return result;

	}

}
