<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Name</title></head>
<body>
<h2>Hello <% out.println(request.getAttribute("name")); %> </h2><br>
Your lucky number is <% out.println(request.getAttribute("lucky")); %> <br>
You have visited this page <% out.println(request.getAttribute("visits")); %> <br>
</body></html>
