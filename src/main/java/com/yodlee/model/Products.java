package com.yodlee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

	Item item[];
	
	String site;


	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.item = item;
	}
	
	
}
