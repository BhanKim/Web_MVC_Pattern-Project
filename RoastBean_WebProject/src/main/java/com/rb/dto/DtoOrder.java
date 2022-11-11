package com.rb.dto;

public class DtoOrder {
	
	int product_id;
	String user_id;
	String order_telno;
	int order_qty;
	int order_price;
	String order_zipcode;
	String address1;
	String address2;
	String address3;
	String order_email;
	String order_name;
	
	public DtoOrder(int product_id, String user_id, String order_telno, int order_qty, int order_price,
			String order_zipcode, String address1, String address2, String address3, String order_email, String order_name) {
		super();
		this.product_id = product_id;
		this.user_id = user_id;
		this.order_telno = order_telno;
		this.order_qty = order_qty;
		this.order_price = order_price;
		this.order_zipcode = order_zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.order_email = order_email;
		this.order_name = order_name;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrder_telno() {
		return order_telno;
	}

	public void setOrder_telno(String order_telno) {
		this.order_telno = order_telno;
	}

	public int getOrder_qty() {
		return order_qty;
	}

	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public String getOrder_zipcode() {
		return order_zipcode;
	}

	public void setOrder_zipcode(String order_zipcode) {
		this.order_zipcode = order_zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getOrder_email() {
		return order_email;
	}

	public void setOrder_email(String order_email) {
		this.order_email = order_email;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	
	
}
