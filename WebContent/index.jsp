<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EasyTaxi | Control Panel</title>
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
  </head>
  <body>
    <form method = "POST" action="LoginAdmin">
      <div class="header-login">
        <img src="images/EasyTaxiLogo.png" alt="EasyTaxiLogo">
      </div>
      <div class="body-login">
        <div class="content-login">
          <span>UserName</span> <input type="text" name="uname">
        </div>
        <div class="content-login">
        <span>Password</span> <input type="password" name="pass">
        </div>
        <div class="content-submit">
            <input type="submit" name="submit" value="Login">
        </div>
      </div>
    </form>
  </body>
</html>