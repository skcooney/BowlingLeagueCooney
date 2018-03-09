<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team List</title>
<style>
table, td, th{
	border: 1px solid black;
	boarder-collapse: seperate;
	padding: 2px
}
</style>
</head>
<body>
<h2>Team List</h2>
	<form method = "post" action = "editTeamServlet">
	<table>
			<tr>
			<th>Team Id</th>
			<th>Team Name</th>
			<th>Team Type</th>
			<th>Preferred Night</th>
			</tr>
			
	<c:forEach items = "${requestScope.allTeams}" var = "currentTeam">
	<tr>
		<td><input type = "radio" name = "id" value = "${currentTeam.teamId}">${currentTeam.teamId}</td>
		<td>${currentTeam.teamName}</td>
		<td>${currentTeam.teamType}</td>
		<td>${currentTeam.preferredNight}</td>
	</tr>
	</c:forEach>
	</table><br/>
	<input type = "submit" value = "Delete Team and Players on Team" name = "doThisToTeam"><br /><br />
	<input type = "submit" value = "Add New Team" name = "doThisToTeam">
	</form><br />
	<a href ="index.html"> Back to Main Menu</a><br/>
	</body>
</html>