<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios" %>
<%@ page import="java.util.ArrayList, java.util.Hashtable" %>
<jsp:useBean id="user" class="ejercicio2.display.javabean.CustomerBean" scope="session"></jsp:useBean>
<jsp:useBean id="conexion" class="ejercicio2.display.javabean.BDBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			GestorUsuarios gestorU = new GestorUsuarios();
			
		%>
	</body>
</html>