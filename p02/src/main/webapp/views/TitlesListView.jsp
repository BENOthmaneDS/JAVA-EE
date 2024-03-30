<%@page import="com.esisa.biblio.models.Title"%>
<%@page import="com.esisa.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TitlesListView</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<h1>Liste des auteurs</h1>
	<%
	List<Title> titles = (List<Title>)request.getAttribute("model");
	%>
	<table class="data-table">
		<tr><td>ISBN</td><td>Title</td><td>Year_Published</td><td>Publisher_ID</td></tr>
		<%
			for (Title a : titles) {
		%>
			<tr>
				<td><%=a.getIsbn() %></td>
				<td><%=a.getTitle() %></td>
				<td><%=a.getYearPublished() %></td>
				<td><%=a.getPublishedID() %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>