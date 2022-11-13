package com.rb.dto;

import java.security.Timestamp;

public class DtoCartList {
	
	String user_id;
	int product_id;
	int cart_qty;
	Timestamp cart_date;
	String product_name;
	int product_price;
	int product_weight;
	int product_priceSum;
	String product_image;
	
	public DtoCartList(String user_id, int product_id, int cart_qty, String product_name,
			int product_price, int product_weight, int product_priceSum, String product_image) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.cart_qty = cart_qty;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_weight = product_weight;
		this.product_priceSum = product_priceSum;
		this.product_image = product_image;
	}

	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public Timestamp getCart_date() {
		return cart_date;
	}
	public void setCart_date(Timestamp cart_date) {
		this.cart_date = cart_date;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(int product_weight) {
		this.product_weight = product_weight;
	}
	public int getProduct_priceSum() {
		return product_priceSum;
	}
	public void setProduct_priceSum(int product_priceSum) {
		this.product_priceSum = product_priceSum;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

}
