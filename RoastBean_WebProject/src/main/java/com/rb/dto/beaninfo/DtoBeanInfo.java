package com.rb.dto.beaninfo;

public class DtoBeanInfo {
	
    int beaninfo_id;
    String beaninfo_name;
    String beaninfo_content;
    String beaninfo_url;
    
	public DtoBeanInfo(int beaninfo_id, String beaninfo_name, String beaninfo_content, String beaninfo_url) {
		super();
		this.beaninfo_id = beaninfo_id;
		this.beaninfo_name = beaninfo_name;
		this.beaninfo_content = beaninfo_content;
		this.beaninfo_url = beaninfo_url;
	}

	public int getBeaninfo_id() {
		return beaninfo_id;
	}

	public void setBeaninfo_id(int beaninfo_id) {
		this.beaninfo_id = beaninfo_id;
	}

	public String getBeaninfo_name() {
		return beaninfo_name;
	}

	public void setBeaninfo_name(String beaninfo_name) {
		this.beaninfo_name = beaninfo_name;
	}

	public String getBeaninfo_content() {
		return beaninfo_content;
	}

	public void setBeaninfo_content(String beaninfo_content) {
		this.beaninfo_content = beaninfo_content;
	}

	public String getBeaninfo_url() {
		return beaninfo_url;
	}

	public void setBeaninfo_url(String beaninfo_url) {
		this.beaninfo_url = beaninfo_url;
	}
    
	
    
	
	

}
