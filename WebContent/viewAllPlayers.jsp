<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Players</title>
</head>
<body>
<form method = "post" action = "viewAllPlayersServlet">
	<table>
	<c:forEach items = "${requestScope.allPlayers}" var ="currentplayer">
	<tr>
		<td><input type = "radio" name = "id" value = "${currentplayer.playerId}"></td>
		<td>${currentplayer.firstName}</td>
		<td>${currentplayer.lastName}</td>
		<td>${currentplayer.phoneNumber}</td>
		<td>${currentplayer.screenName}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "Delete Selected Player" name = "doThisToPlayer">
	<input type = "submit" value = "Add New Player" name = "doThisToPlayer">
	</form>
</body>
</html>