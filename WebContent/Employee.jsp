<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EasyTaxi Control Panel | Employee</title>
    <link rel="stylesheet" href="css/controlpanelstyles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
  
  	<!--import layout of the control panel-->
	<jsp:include page="/WEB-INF/views/layout.jsp"></jsp:include>
	
    <div class="dv_right">
      <div class="header-block">
        <h3>Employee Control</h3>
        <a href="<%=request.getContextPath()%>/NewEmployee"><button type="button">ADD EMPLOYEE</button></a>
      </div><br><br>
          
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">EmpID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Address</th>
            <th scope="col">Email</th>
            <th scope="col">Mobile</th>
            <th scope="col">Salary</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
        
        <!-- Fetch Data From ~easytaxi~ Database ~employeer~ Table -->
        
        <c:forEach var="employee" items="${listEmployee}">
           <tr>
             <td><c:out value="${employee.empid}" /></td>
             <td><c:out value="${employee.firstname}" /></td>
             <td><c:out value="${employee.lastname}" /></td>
             <td><c:out value="${employee.address}" /></td>
             <td><c:out value="${employee.email}" /></td>
             <td><c:out value="${employee.mobile}" /></td>
             <td><c:out value="${employee.salary}" /></td>
             <td>
               <a href="EditEmployee?empid=<c:out value='${employee.empid}' />"><button type="button" name="button" class="update-btn">Update</button></a>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="DeleteEmployee?empid=<c:out value='${employee.empid}' />"><button type="button" name="button" class="delete-btn">Delete</button></a>
             </td>
           </tr>
         </c:forEach>
       </tbody>
     </table>
	</div>
  </body>
</html>
