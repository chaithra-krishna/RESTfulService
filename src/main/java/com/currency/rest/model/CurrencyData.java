/**
 * 
 */
package com.currency.rest.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Macbook pro
 *
 */
public class CurrencyData implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("currencyFrom")
	private String currencyFrom;

	@JsonProperty("currencyTo")
	private String currencyTo;

	@JsonProperty("amountSell")
	private Integer amountSell;

	@JsonProperty("amountBuy")
	private Double amountBuy;

	@JsonProperty("rate")
	private Double rate;

	@JsonProperty("timePlaced")
	private String timePlaced;

	@JsonProperty("originatingCountry")
	private String originatingCountry;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("currencyFrom")
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	@JsonProperty("currencyFrom")
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	@JsonProperty("currencyTo")
	public String getCurrencyTo() {
		return currencyTo;
	}

	@JsonProperty("currencyTo")
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	@JsonProperty("amountSell")
	public Integer getAmountSell() {
		return amountSell;
	}

	@JsonProperty("amountSell")
	public void setAmountSell(Integer amountSell) {
		this.amountSell = amountSell;
	}

	@JsonProperty("amountBuy")
	public Double getAmountBuy() {
		return amountBuy;
	}

	@JsonProperty("amountBuy")
	public void setAmountBuy(Double amountBuy) {
		this.amountBuy = amountBuy;
	}

	@JsonProperty("rate")
	public Double getRate() {
		return rate;
	}

	@JsonProperty("rate")
	public void setRate(Double rate) {
		this.rate = rate;
	}

	@JsonProperty("timePlaced")
	public String getTimePlaced() {
		return timePlaced;
	}

	@JsonProperty("timePlaced")
	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	@JsonProperty("originatingCountry")
	public String getOriginatingCountry() {
		return originatingCountry;
	}

	@JsonProperty("originatingCountry")
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyData [userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate + ", timePlaced="
				+ timePlaced + ", originatingCountry=" + originatingCountry + ", additionalProperties="
				+ additionalProperties + "]";
	}

}
