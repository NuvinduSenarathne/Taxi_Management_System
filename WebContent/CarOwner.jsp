<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EasyTaxi Control Panel | Car Owner</title>
    <link rel="stylesheet" href="css/controlpanelstyles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
    
    <!--import layout of the control panel-->
    <jsp:include page="/WEB-INF/views/layout.jsp"></jsp:include>
    
    <div class="dv_right">
      <div class="header-block">
        <h3>Car Owner Control</h3>
        
		<!-- add car owner -->
        <a href="<%=request.getContextPath()%>/NewOwner"><button type="button">ADD OWNER</button></a>
      
      </div><br><br>
    
      <table class="table table-striped">
         <thead>
           <tr>
             <th scope="col">OwnerID</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Email</th>
              <th scope="col">Mobile</th>
              <th scope="col">NIC</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            
          <!-- Fetch Data From ~easytaxi~ Database ~owner~ Table -->
            
          <c:forEach var="owner" items="${listOwner}">
            <tr>
              <th scope="row"><c:out value="${owner.userid}" /></th>
              <td><c:out value="${owner.firstname}" /></td>
              <td><c:out value="${owner.lastname}" /></td>
              <td><c:out value="${owner.email}" /></td>
              <td><c:out value="${owner.mobile}" /></td>
              <td><c:out value="${owner.nic}" /></td>
              <td scope="col">
                <button type="button" class="update-btn">Payment</button>
              </td>
           </tr>
       </c:forEach>
      </tbody>
     </table>
    </div>
  </body>
  </html>
