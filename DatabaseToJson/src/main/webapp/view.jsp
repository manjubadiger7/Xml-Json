<%@page import="java.util.LinkedList"%>
<%@page import="model.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Page</title>
</head>
<body>
	<%
		List<Person> persons = new LinkedList<Person>();
	%>
	<%
		String personsToJson = null;
	%>
	<%
		persons = (List<Person>) session.getAttribute("persons");
	%>
	<%
		personsToJson = (String) session.getAttribute("personsToJson");
	%>
	<%
		out.println(persons.toString());
	%>
	<%
		out.println(personsToJson);
	%>
</body>
</html>