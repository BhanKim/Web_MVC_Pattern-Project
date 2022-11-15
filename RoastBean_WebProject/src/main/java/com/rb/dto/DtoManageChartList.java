package com.rb.dto;

public class DtoManageChartList {
	
	int visit_id;
	int visit_date;
	int visit_number;
	int profit_date;
	int profit_amount;
	
	public DtoManageChartList(int visit_id, int visit_date, int visit_number) {
		super();
		this.visit_id = visit_id;
		this.visit_date = visit_date;
		this.visit_number = visit_number;
	}

	public DtoManageChartList(int profit_date, int profit_amount) {
		super();
		this.profit_date = profit_date;
		this.profit_amount = profit_amount;
	}

	public int getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}

	public int getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(int visit_date) {
		this.visit_date = visit_date;
	}

	public int getVisit_number() {
		return visit_number;
	}

	public void setVisit_number(int visit_number) {
		this.visit_number = visit_number;
	}

	public int getProfit_date() {
		return profit_date;
	}

	public void setProfit_date(int profit_date) {
		this.profit_date = profit_date;
	}

	public int getProfit_amount() {
		return profit_amount;
	}

	public void setProfit_amount(int profit_amount) {
		this.profit_amount = profit_amount;
	}
	
}
