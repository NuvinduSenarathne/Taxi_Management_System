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

import com.EasyTaxiCTRL.dao.OwnerPaymentDao;
import com.EasyTaxiCTRL.model.OwnerPayment;

@WebServlet("/InsertOwnerPayment")
public class InsertOwnerPaymentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnerPaymentDao ownerPaymentDao;
	
	public void init() {
		ownerPaymentDao = new OwnerPaymentDao();
	}

    public InsertOwnerPaymentSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehiclename = request.getParameter("vehiclename");
		int ownerid = Integer.parseInt(request.getParameter("ownerid"));
		String date = request.getParameter("date");
		float chargePerKM = Float.parseFloat(request.getParameter("chargePerKM"));
		int noOfKM = Integer.parseInt(request.getParameter("noOfKM"));
		OwnerPayment newownerpayment = new OwnerPayment(vehiclename, ownerid, date, chargePerKM, noOfKM);
		try {
			ownerPaymentDao.insertOwnerPayment(newownerpayment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ownerpaymentlist");
	}

}
