/**
 * 
 */
package com.currency.rest.services;

import com.currency.rest.model.CurrencyData;

/**
 * @author Macbook pro
 *
 */
public interface CurrencyService {

	public void subbmitToQueue(CurrencyData currencyData);
}
