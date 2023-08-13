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
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <title>EasyTaxi | Add Employee</title>
  </head>
  <body>
  
    <jsp:include page="/WEB-INF/views/layout.jsp"></jsp:include>
    
    <div class="dv_right">
      <div class="block2">
        <form class="addEmpForm" action="InsertDriver" method="post">
          <table>
            <tr>
              <th colspan="2">ADD DRIVER</th>
            </tr>
            <tr>
              <td><span>First Name</span></td>
              <td><input type="text" name="firstname"></td>
            </tr>
            <tr>
              <td><span>Last Name</span></td>
              <td><input type="text" name="lastname"></td>
            </tr>
            <tr>
              <td><span>Email</span></td>
              <td><input type="text" name="email"></td>
            </tr>
            <tr>
              <td><span>Mobile</span></td>
              <td><input type="text" name="mobile"></td>
            </tr>
            <tr>
              <td><span>License No</span></td>
              <td><input type="text" name="licenseno"></td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </body>
  </html>
