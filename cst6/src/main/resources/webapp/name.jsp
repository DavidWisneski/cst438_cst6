<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Name</title></head>
<body>Today is <% out.println( new java.util.Date().toString() ); %><br>
<form method="POST" action="NameServlet">
Enter name <input type="text" name="name"/><br>
<input type=Submit name="submit" />
</form></body></html>