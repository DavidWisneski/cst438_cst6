<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hangman</title>
</head>

<body>
<img src="h<%out.println(request.getAttribute("FILECOUNT"));%>.gif"/>

<h2 style="font-family:'Lucida Console', monospace"> 
<%out.println(request.getAttribute("DISPLAY")); %> 
</h2>

<form method="post" action="Hangman">
Guess a character 
<input type="text" name="guess">
<br>
<input type="submit" value="Submit">
</form>

</body>
</html>