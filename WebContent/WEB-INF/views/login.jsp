<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	@charset "ISO-8859-1";

body {
  background-color: rgba(0, 0, 0, .6);
  border: 0;
  margin: 0;
  padding: 0;
}

form {
  width: 400px;
  height: 450px;
  border: 5px solid #524E51;
  background-color: gainsboro;
  border-radius: 4px;
  position: fixed;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
}

.header-login {
  display: block;
  width: 100%;
  height: 100px;
}

.header-login img {
  width: 175px;
  margin-top: 50px;
  display: flex;
  margin-left: auto;
  margin-right: auto;
}

.body-login {
  width: 80%;
  margin-top: 50px;
  margin-left: auto;
  margin-right: auto;
}

.content-login {
  display: block;
  width: 100%;
  margin-top: 25px;
  margin-bottom: 25px;
  font-family: 'Ubuntu', sans-serif;
  font-size: 20px;
  font-weight: bold;
}

.content-login span {
  color: rgb(64,64,64);
  vertical-align: middle;
  font-weight: bold;
  cursor: default;
}

.content-login input {
  float: right;
  border: 2px solid rgb(64,64,64);
  height: 25px;
  width: 175px;
}

.content-submit [type=submit] {
  background-color: rgb(49,120,235);
  color: whitesmoke;
  height: 40px;
  width: 120px;
  border-radius: 5px;
  border: 1px solid rgb(49,120,235);
  margin-top: 30px;
  cursor: pointer;
  display: flex;
  margin-left: auto;
  margin-right: auto;
}

.content-login button:hover {
  background-color: #4484CE;
  border: 1px solid #4484CE;
}
	
</style>
</head>
<body>
</body>
</html>