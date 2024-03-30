<%@page import="com.esisa.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AuthorsListView</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<h1>Liste des auteurs</h1>
	<%
	List<Author> authors = (List<Author>)request.getAttribute("model");
	%>
	<table class="data-table">
		<tr><td>Id</td><td>Nom</td><td>Année</td></tr>
		<%
			for (Author a : authors) {
		%>
			<tr>
				<td><%=a.getId() %></td>
				<td><%=a.getName() %></td>
				<td><%=a.getYearBorn() %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>