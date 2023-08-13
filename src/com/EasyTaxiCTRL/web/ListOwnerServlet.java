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

import com.EasyTaxiCTRL.dao.OwnerDao;
import com.EasyTaxiCTRL.model.CarOwner;

@WebServlet("/ListOwner")
public class ListOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CarOwner> listOwner = OwnerDao.selectAllOwners();
		request.setAttribute("listOwner", listOwner);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CarOwner.jsp");
		dispatcher.forward(request, response);
	}

}
