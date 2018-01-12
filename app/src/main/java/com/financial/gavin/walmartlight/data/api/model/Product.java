package com.financial.gavin.walmartlight.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by gavin on 1/10/18.
 */

public class Product {
	
	@SerializedName("items")
	@Expose
	private List<Item> items;
	
	@SerializedName("numItems")
	@Expose
	private int numItems;
	
	public Product(List<Item> items, int numItems) {
		this.items = items;
		this.numItems = numItems;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
}
