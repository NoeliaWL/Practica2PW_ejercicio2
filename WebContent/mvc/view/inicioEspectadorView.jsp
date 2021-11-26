<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
		<body onload="getParams()">
			<%
				String nombre = request.getParameter("nombreUser");
				String fechaRegistro = request.getParameter("fechaRegistro");
			%>
			<h2>Bienvenido <%=nombre%></h2>
			<p>Fecha Actual: <%= new java.util.Date() %></p>
			<p>Fecha de registro de su usuario: <%=fechaRegistro%></p>
			
			<input type="button" value="Button Prueba" onclick="window.location.href='../controller/actualizarDatosController.jsp'">
		</body>
</html>