<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.metier.Usager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Factures</title>
</head>
<body>
	<h1>
		<% 
			Usager u  = (Usager) request.getAttribute("usager");
			out.println(u.getNom() + " " + u.getPrenom()); 
		%>
	</h1>
</body>
</html>