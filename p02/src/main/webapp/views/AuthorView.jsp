<%@page import="com.esisa.biblio.models.Author"%><!-- classe importer -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AuthorView</title>
</head>
<body>
	<h1>Author found : ${model.name}</h1>
	
	<!-- scriptlet -->
	<%
		Author model = (Author)request.getAttribute("model");
	%>
	<table>
		<tr><td>Id : </td><td><%= model.getId() %></td></tr><!-- tag d'expression -->
		<tr><td>Nom : </td><td><%= model.getName() %></td></tr>
		<tr><td>Annee : </td><td><%= model.getYearBorn() %></td></tr>
	</table>
</body>
</html>

