package com.rb.dto;

import java.sql.Timestamp;

public class DtoManageProductList {
	int product_id;
	String product_name;
	String product_nation;
	String product_image;
	String product_info;
	int product_stock;
	int product_weight;
	int product_price;
	Timestamp product_initdate;
	Timestamp product_updstedate;
	Timestamp product_deletedate;
	//-----------------------------
	int category_seq;
	String category_type;
	String category_acidity;
	String category_aroma;
	String category_body;
	String category_sweet;
	//-----------------------------
	int order_seq ;
	String user_id ;
	String order_name ;
	String order_address ;

	String order_email ;
	String order_telno ;
	int order_qty ;
	int order_price ;
	Timestamp order_date ;
	//------------------------------
	public DtoManageProductList(int product_id, String product_name, String product_nation, String product_image,
			String product_info, int product_stock, int product_weight, int product_price,
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
			String product_info, int product_stock, int product_weight, int product_price) {
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
	
	public DtoManageProductList(int category_seq, String category_type, String category_acidity, String category_aroma,
			String category_body, String category_sweet) {
		super();
		this.category_seq = category_seq;
		this.category_type = category_type;
		this.category_acidity = category_acidity;
		this.category_aroma = category_aroma;
		this.category_body = category_body;
		this.category_sweet = category_sweet;
	}
	
	public DtoManageProductList(int product_id, int category_seq, String category_type, String category_acidity,
			String category_aroma, String category_body, String category_sweet) {
		super();
		this.product_id = product_id;
		this.category_seq = category_seq;
		this.category_type = category_type;
		this.category_acidity = category_acidity;
		this.category_aroma = category_aroma;
		this.category_body = category_body;
		this.category_sweet = category_sweet;
	}
	
	

	public DtoManageProductList(int product_id, String product_name, String product_nation, String product_image,
			String product_info, int product_stock, int product_weight, int product_price, String category_type,
			String category_acidity, String category_aroma, String category_body, String category_sweet) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_nation = product_nation;
		this.product_image = product_image;
		this.product_info = product_info;
		this.product_stock = product_stock;
		this.product_weight = product_weight;
		this.product_price = product_price;
		this.category_type = category_type;
		this.category_acidity = category_acidity;
		this.category_aroma = category_aroma;
		this.category_body = category_body;
		this.category_sweet = category_sweet;
	}
	


	public DtoManageProductList(int product_id, int order_seq, String user_id, String order_name, String order_address,
			String order_email, String order_telno, int order_qty, int order_price, Timestamp order_date) {
		super();
		this.product_id = product_id;
		this.order_seq = order_seq;
		this.user_id = user_id;
		this.order_name = order_name;
		this.order_address = order_address;
		this.order_email = order_email;
		this.order_telno = order_telno;
		this.order_qty = order_qty;
		this.order_price = order_price;
		this.order_date = order_date;
	}
	public DtoManageProductList(int product_id) {
		// TODO Auto-generated constructor stub
		super();
		this.product_id = product_id;
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
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public int getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(int product_weight) {
		this.product_weight = product_weight;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
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
	public int getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_email() {
		return order_email;
	}
	public void setOrder_email(String order_email) {
		this.order_email = order_email;
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
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	
	
	
	
}
