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



@WebServlet("/InsertOwner")
public class InsertOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnerDao ownerDao;
	
	public void init() {
		ownerDao = new OwnerDao();
	}

    public InsertOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String nic = request.getParameter("nic");
		CarOwner newOwner = new CarOwner(firstname, lastname, email, mobile, nic);
		try {
			ownerDao.insertOwner(newOwner);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ListOwner");
	}

}
