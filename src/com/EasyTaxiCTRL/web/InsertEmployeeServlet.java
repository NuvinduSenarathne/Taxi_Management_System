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

import com.EasyTaxiCTRL.dao.EmployeeDao;
import com.EasyTaxiCTRL.model.Employee;

@WebServlet("/InsertEmployee")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao EmpDao;
	
	public void init() {
		EmpDao = new EmployeeDao();
	}

    public InsertEmployeeServlet() {
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
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		float salary = Float.parseFloat(request.getParameter("salary"));
		Employee newEmployee = new Employee(firstname, lastname, address, email, mobile, salary);
		try {
			EmpDao.insertEmployee(newEmployee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ListEmployee");
	}

}
