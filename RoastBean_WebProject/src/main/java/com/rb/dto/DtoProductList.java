package com.rb.dto;


public class DtoProductList {
	
	int product_id;
	String product_name;
	int product_weight;
	String product_info;
	int product_price;
	int product_stock;
	
	public DtoProductList(int product_id, String product_name, int product_weight, String product_info,
			int product_price, int product_stock) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_weight = product_weight;
		this.product_info = product_info;
		this.product_price = product_price;
		this.product_stock = product_stock;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_weight() {
		return product_weight;
	}

	public void setProduct_weight(int product_weight) {
		this.product_weight = product_weight;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	
}
