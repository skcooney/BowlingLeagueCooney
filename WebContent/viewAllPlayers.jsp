<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player List</title>
<style>
table, td, th{
	border: 1px solid black;
	boarder-collapse: seperate;
	padding: 2px
}
</style>
</head>
<body>
<h2>Player List</h2>
<form method = "post" action = "editPlayerServlet">
	<table>
	<tr>
			<th>Player ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Phone Number</th>
			<th>Screen Name</th>
			<th>Team</th>
			</tr>
	<c:forEach items = "${requestScope.allPlayers}" var ="currentPlayer">
	<tr>
		<td><input type = "radio" name = "id" value = "${currentPlayer.playerId}">${currentPlayer.playerId}</td>
		<td>${currentPlayer.firstName}</td>
		<td>${currentPlayer.lastName}</td>
		<td>${currentPlayer.phoneNumber}</td>
		<td>${currentPlayer.screenName}</td>
		<td>${currentPlayer.team.getTeamName()}
	</tr>
	</c:forEach>
	</table><br /><br />
	<input type = "submit" value = "Delete Player" name = "doThisToPlayer"><br /><br />
	<input type = "submit" value = "Add New Player" name = "doThisToPlayer">
	</form><br />
	<a href ="index.html"> Back to the Main Menu</a><br/>
</body>
</html>