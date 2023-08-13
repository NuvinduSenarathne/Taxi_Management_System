package com.EasyTaxiCTRL.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyTaxiCTRL.dao.VehicleDao;
import com.EasyTaxiCTRL.model.Vehicle;

@WebServlet("/ListVehicle")
public class ListVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vehicle> listVehicle = VehicleDao.selectAllVehicles();
		request.setAttribute("listVehicle", listVehicle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Vehicle.jsp");
		dispatcher.forward(request, response);
	}

}
