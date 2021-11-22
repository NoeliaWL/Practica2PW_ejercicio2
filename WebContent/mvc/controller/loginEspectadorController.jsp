<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios" %>
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
			String url = request.getRequestURL().toString();
			String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
						
			String correo = "";
			if (request.getParameter("correo") != null){
				correo = request.getParameter("correo") ;
			}
			
			String password = "";
			if (request.getParameter("password") != null){
				password = request.getParameter("password");
			}
			
			if(correo == "" && password == "") {
				%>
				<jsp:forward page="../view/loginEspectadorView.jsp"></jsp:forward>
				<%
			}
			
			GestorUsuarios gestorU = new GestorUsuarios();
			int status = -1;
			
			status = gestorU.loginEspectador(correo, password, conexion);
						
			if(status == 2) {
				user.setCorreoUser(correo);
				%>
				<jsp:forward page="inicioEspectadorController.jsp"></jsp:forward>
				<%
			}
			else if(status == 1) {
				user.setMensaje("Contraseña incorrecta.");
				response.sendRedirect(baseURL);
			}
			else if(status == 0){
				user.setMensaje("Usuario no registrado.");
				response.sendRedirect(baseURL);
			}
			%>
	</body>
</html>