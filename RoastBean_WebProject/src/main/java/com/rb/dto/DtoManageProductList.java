package com.rb.dto;

import java.sql.Timestamp;

public class DtoManageProductList {
	int product_id;
	String product_name;
	String product_nation;
	String product_image;
	String product_info;
	String product_stock;
	String product_weight;
	String product_price;
	Timestamp product_initdate;
	Timestamp product_updstedate;
	Timestamp product_deletedate;
	public DtoManageProductList(int product_id, String product_name, String product_nation, String product_image,
			String product_info, String product_stock, String product_weight, String product_price,
			Timestamp product_initdate) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_nation = product_nation;
		this.product_image = product_image;
		this.product_info = product_info;
		this.product_stock = product_stock;
		this.product_weight = product_weight;
		this.product_price = product_price;
		this.product_initdate = product_initdate;
	}
	public DtoManageProductList(int product_id, String product_name, String product_nation, String product_image,
			String product_info, String product_stock, String product_weight, String product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_nation = product_nation;
		this.product_image = product_image;
		this.product_info = product_info;
		this.product_stock = product_stock;
		this.product_weight = product_weight;
		this.product_price = product_price;
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
	public String getProduct_nation() {
		return product_nation;
	}
	public void setProduct_nation(String product_nation) {
		this.product_nation = product_nation;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_info() {
		return product_info;
	}
	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}
	public String getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public Timestamp getProduct_initdate() {
		return product_initdate;
	}
	public void setProduct_initdate(Timestamp product_initdate) {
		this.product_initdate = product_initdate;
	}
	public Timestamp getProduct_updstedate() {
		return product_updstedate;
	}
	public void setProduct_updstedate(Timestamp product_updstedate) {
		this.product_updstedate = product_updstedate;
	}
	public Timestamp getProduct_deletedate() {
		return product_deletedate;
	}
	public void setProduct_deletedate(Timestamp product_deletedate) {
		this.product_deletedate = product_deletedate;
	}
	
	
}
