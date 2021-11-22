<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body>
		<jsp:useBean id="user" class="ejercicio2.display.javabean.CustomerBean" scope="session"></jsp:useBean>
		
		<jsp:forward page="../view/inicioAdministradorView.jsp">
			<jsp:param value="<%=user.getCorreoUser()%>" name="correoUser"/>
		</jsp:forward>
	</body>
</html>