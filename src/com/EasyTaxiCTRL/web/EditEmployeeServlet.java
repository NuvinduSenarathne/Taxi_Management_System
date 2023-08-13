package com.EasyTaxiCTRL.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyTaxiCTRL.dao.EmployeeDao;
import com.EasyTaxiCTRL.model.Employee;

@WebServlet("/EditEmployee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao EmpDao;
	
	public void init() {
		EmpDao = new EmployeeDao();
	}

    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		Employee existingEmployee = EmpDao.selectEmployee(empid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployeeForm.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);
	}

}
