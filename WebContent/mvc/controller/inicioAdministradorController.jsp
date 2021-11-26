<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios" %>
<jsp:useBean id="conexion" class="ejercicio2.display.javabean.BDBean"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body>
		<jsp:useBean id="user" class="ejercicio2.display.javabean.CustomerBean" scope="session"></jsp:useBean>
		
		<%
			GestorUsuarios gestor = new GestorUsuarios();
			String administradores = gestor.ConsultarUsuariosAdministradores(conexion);
		%>
		
		<jsp:forward page="../view/inicioAdministradorView.jsp">
			<jsp:param value="<%=user.getCorreoUser()%>" name="correoUser"/>
			<jsp:param value="<%=administradores%>" name="admin"/>
		</jsp:forward>
	</body>
</html>