<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios, ejercicio1.data.common.Tipousuario" %>
<%@ page import="java.util.ArrayList, java.util.Hashtable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body>
		<jsp:useBean id="conexion" class="ejercicio2.display.javabean.BDBean" scope="session"></jsp:useBean>
		<%
			String correo = request.getParameter("correoUser");
		
			//Consulta para rescatar datos de todos los usuarios
			/*GestorUsuarios gestorU = new GestorUsuarios();
			
			ArrayList<Hashtable<String, String>> administradores = gestorU.ConsultarUsuariosAdministradores(conexion);*/
		%>
		
		<p><%=correo %></p>
	</body>
</html>