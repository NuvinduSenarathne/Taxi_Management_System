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

import com.EasyTaxiCTRL.dao.VehicleDao;

@WebServlet("/DeleteVehicle")
public class DeleteVeicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleDao vehicleDao;
	
	public void init() {
		vehicleDao = new VehicleDao();
	}

    public DeleteVeicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vehicleid = Integer.parseInt(request.getParameter("vehicleid"));
		try {
			vehicleDao.deleteVehicle(vehicleid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ListVehicle");
	}

}
