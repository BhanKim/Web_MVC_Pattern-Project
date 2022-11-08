package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.beaninfo.DaoBeanInfo;
import com.rb.dto.beaninfo.DtoBeanInfo;

public class CommandBeanInfo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoBeanInfo dao = new DaoBeanInfo();
		System.out.println("CommandBeanInfo가 실행되었습니다.");
		ArrayList<DtoBeanInfo> dtos = dao.list();

		request.setAttribute("list", dtos);

	}

}
