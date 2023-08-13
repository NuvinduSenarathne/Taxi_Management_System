<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/controlpanelstyles.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Sans&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <title>EasyTaxi | Add Employee</title>
  </head>
  <body>
    
    <jsp:include page="/WEB-INF/views/layout.jsp"></jsp:include>
    
    <div class="dv_right">
      <div class="block2">
        <form class="addEmpForm" action="ownerpayment" method="post">
          <table>
            <tr>
              <th colspan="2">CAR OWNER PAYMENTS</th>
            </tr>
            <tr>
              <td><span>Owner ID</span></td>
              <td><input type="text" name="ownerid"></td>
            </tr>
            <tr>
              <td><span>Vehicle Name</span></td>
              <td><input type="text" name="vehiclename"></td>
            </tr>
            <tr>
              <td><span>Date</span></td>
              <td><input type="text" name="date"></td>
            </tr>
            <tr>
              <td><span>Charges Per km</span></td>
              <td><input type="text" name="chargePerKM"></td>
            </tr>
            <tr>
              <td><span>No Of km</span></td>
              <td><input type="text" name="noOfKM"></td>
            </tr>
            <tr>
            <tr>
              <td colspan="2"><input type="submit" name="submit" value="Submit"></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </body>
  </html>
