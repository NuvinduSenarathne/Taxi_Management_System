<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Sans&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <title>EasyTaxi Control Panel</title>
  </head>
  <body>
    <div class="dv_left">
      <h2>Control Panel</h2>
      <div class="btn_section">
        <a href="<%=request.getContextPath()%>/ListVehicle"><button class="btn_panel" type="button">Vehicle</button></a>
        <a href="<%=request.getContextPath()%>/ListCustomer"><button class="btn_panel" type="button">Customer</button></a>
        <a href="<%=request.getContextPath()%>/ListOwner"><button class="btn_panel" type="button">Car Owner</button></a>
        <a href="<%=request.getContextPath()%>/ListDriver"><button class="btn_panel" type="button">Driver</button></a>
        <a href="<%=request.getContextPath()%>/ListEmployee"><button class="btn_panel" type="button">Employee</button></a>
        <a href="Reservation.jsp"><button class="btn_panel" type="button">Reservation</button></a>
        <a href="ContactUs.jsp"><button class="btn_panel" type="button">Contact Us</button></a>
        <a href="Loguout.jsp"><button class="btn_panel" type="button">LogOut</button></a>
      </div>
    </div>
    <div class="fixed-bar"></div> 
  </body>
</html>