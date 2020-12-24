package com.lti.demo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customers;

//@WebServlet("/demo")
public class WebDemo extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Customers c = new Customers();
		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = request.getParameter("date");
		LocalDate localDate = LocalDate.parse(date);
		c.setDateOfBirth(localDate);
		CustomerDao dao = new CustomerDao();
		dao.dataStore(c);
		// doGet(request, response);
	}

}
