<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios, java.time.LocalDateTime" %>
<jsp:useBean id="user" class="ejercicio2.display.javabean.CustomerBean" scope="session"></jsp:useBean>
<jsp:useBean id="conexion" class="ejercicio2.display.javabean.BDBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body>
		<%
			//Consultar fecha de registro del usuario y nombre del usuario logueado
			GestorUsuarios gestorU = new GestorUsuarios();	
			
			String nombre = gestorU.ConsultarUsuariosEspectadores(user.getCorreoUser(), conexion);
			LocalDateTime fechaRegistro = gestorU.ConsultarFechaRegistroEspectador(user.getCorreoUser(), conexion); 
		%>
	
			<jsp:forward page="../view/inicioEspectadorView.jsp">
				<jsp:param name="nombreUser" value="<%=nombre%>"/>
				<jsp:param name="fechaRegistro" value="<%=fechaRegistro%>"/>
			</jsp:forward>
	</body>
</html>