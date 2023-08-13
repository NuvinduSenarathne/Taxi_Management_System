<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EasyTaxi Control Panel | Vehicle</title>
    <link rel="stylesheet" href="css/controlpanelstyles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
  
  	<!--import layout of the control panel-->
	<jsp:include page="/WEB-INF/views/layout.jsp"></jsp:include>
	
    <div class="dv_right">
      <div class="header-block">
        <h3>Vehicle Control</h3>
      </div><br><br>
          
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">VehicleID</th>
            <th scope="col">Vehicle Name</th>
            <th scope="col">Registration</th>
            <th scope="col">Year</th>
            <th scope="col">District</th>
            <th scope="col">Type</th>
            <th scope="col">Passengers</th>
            <th scope="col">Action</th>
          </tr>
       </thead>
       <tbody>
       
          <!-- Fetch Data From ~easytaxi~ Database ~vehicle~ Table -->
       
         <c:forEach var="vehicle" items="${listVehicle}">
           <tr>
             <td><c:out value="${vehicle.vehicleid}" /></td>
             <td><c:out value="${vehicle.vehiclename}" /></td>
             <td><c:out value="${vehicle.regno}" /></td>
             <td><c:out value="${vehicle.manufactureyear}" /></td>
             <td><c:out value="${vehicle.district}" /></td>
             <td><c:out value="${vehicle.vehicletype}" /></td>
             <td><c:out value="${vehicle.passengers}" /></td>
             <td>
               <a href="DeleteVehicle?vehicleid=<c:out value='${vehicle.vehicleid}' />"><button type="button" class="delete-btn">Delete</button></a>
             </td>
          </tr>
         </c:forEach>
        </tbody>
      </table>
	</div>
  </body>
</html>
