package com.EasyTaxiCTRL.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyTaxiCTRL.dao.DriverDao;
import com.EasyTaxiCTRL.model.Driver;



@WebServlet("/ListDriver")
public class ListDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Driver> listDriver = DriverDao.selectAllDrivers();
		request.setAttribute("listDriver", listDriver);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Driver.jsp");
		dispatcher.forward(request, response);
	}

}
