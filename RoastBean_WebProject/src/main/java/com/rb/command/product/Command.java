package com.rb.command.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command { // Interface !!
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
