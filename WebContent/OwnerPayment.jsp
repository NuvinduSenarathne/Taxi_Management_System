<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/controlpanelstyles.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>EasyTaxi Control Panel</title>
  </head>
  <body>
    
    <jsp:include page="/WEB-INF/views/layout.jsp"></jsp:include>
    
    <div class="dv_right">
      <div class="header-block">
        <h3>Owner Payments</h3>
      </div><br><br>
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">OwnerID</th>
                <th scope="col">VehicleName</th>
                <th scope="col">Date</th>
                <th scope="col">ChargePerKM</th>
                <th scope="col">NoOfKM</th>
                <th scope="col">Payment</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="ownerpayment" items="${listOwnerPayment}">
              <tr>
                <th scope="row"><c:out value="${ownerpayment.paymentid}" /></th>
                <td><c:out value="${driverpayment.vehiclename}" /></td>
                <td><c:out value="${driverpayment.date}" /></td>
                <td><c:out value="${driverpayment.chargePerKM}" /></td>
                <td><c:out value="${driverpayment.noOfKM}" /></td>
                <td><c:out value="${driverpayment.payment}" /></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          </div>
  </body>
  </html>
