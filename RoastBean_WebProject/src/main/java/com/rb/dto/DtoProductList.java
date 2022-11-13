package com.rb.dto;

import java.sql.Timestamp;

public class DtoProductList {
	
	int product_id;
	String product_name;
	int product_weight;
	String product_info;
	int product_price;
	int product_stock;
	String product_image;
	String category_type;
	String category_acidity;
	String category_aroma;
	String category_body;
	String category_sweet;
	int order_seq;
	int order_qty;
	int order_price;
	
	public DtoProductList(int product_id, String product_name, int product_weight, String product_info,
			int product_price, int product_stock, String product_image, String category_type, String category_acidity, String category_aroma, String category_body, String category_sweet) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_weight = product_weight;
		this.product_info = product_info;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_image = product_image;
		this.category_type = category_type;
		this.category_acidity = category_acidity;
		this.category_aroma = category_aroma;
		this.category_body = category_body;
		this.category_sweet = category_sweet;
	}
	
	public DtoProductList(int product_id, String product_name, int product_weight, String product_info,
			int product_price, int product_stock, String product_image) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_weight = product_weight;
		this.product_info = product_info;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_image = product_image;
	}
	

	public DtoProductList(int product_id, String product_name, int product_weight, String product_image, int order_seq,
			int order_qty, int order_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_weight = product_weight;
		this.product_image = product_image;
		this.order_seq = order_seq;
		this.order_qty = order_qty;
		this.order_price = order_price;
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

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getCategory_type() {
		return category_type;
	}

	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}

	public String getCategory_acidity() {
		return category_acidity;
	}

	public void setCategory_acidity(String category_acidity) {
		this.category_acidity = category_acidity;
	}

	public String getCategory_aroma() {
		return category_aroma;
	}

	public void setCategory_aroma(String category_aroma) {
		this.category_aroma = category_aroma;
	}

	public String getCategory_body() {
		return category_body;
	}

	public void setCategory_body(String category_body) {
		this.category_body = category_body;
	}

	public String getCategory_sweet() {
		return category_sweet;
	}

	public void setCategory_sweet(String category_sweet) {
		this.category_sweet = category_sweet;
	}

	public int getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
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
	
	
	
}