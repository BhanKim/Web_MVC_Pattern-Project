package com.rb.dto;

public class DtoMyOrderlist {
	
	int product_id;
	int order_seq;
	String product_image;
	String product_name;
	int product_weight;
	String order_date;
	int order_price;
	int order_qty;
	
	public DtoMyOrderlist() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoMyOrderlist(int product_id, int order_seq, String product_image, String product_name, int product_weight,
			String order_date, int order_price, int order_qty) {
		super();
		this.product_id = product_id;
		this.order_seq = order_seq;
		this.product_image = product_image;
		this.product_name = product_name;
		this.product_weight = product_weight;
		this.order_date = order_date;
		this.order_price = order_price;
		this.order_qty = order_qty;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
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

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getOrder_qty() {
		return order_qty;
	}

	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	

}
