<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios" %>
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
			String url = request.getRequestURL().toString();
			String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
			
			String nombre= "", apellidos = "", nick = "", correo = "", contrasena = "", tipo = "";
			if(request.getParameter("nombre") != null) {
				nombre =  request.getParameter("nombre");
			}
			if(request.getParameter("apellidos") != null) {
				apellidos =  request.getParameter("apellidos");
			}
			if(request.getParameter("nick") != null) {
				nick =  request.getParameter("nick");
			}
			if(request.getParameter("correo") != null) {
				correo =  request.getParameter("correo");
			}
			if(request.getParameter("password") != null) {
				contrasena =  request.getParameter("password");
			}
			if(request.getParameter("tipo") != null) {
				tipo =  request.getParameter("tipo");
			}
			
			if(nombre=="" && apellidos=="" && nick=="" && correo=="" && contrasena=="" && tipo=="") {
		%>
				<jsp:forward page="../view/registroView.jsp"></jsp:forward>
		<%
			}

			GestorUsuarios gestorU = new GestorUsuarios();
		
			if(tipo.equals("ADMINISTRADOR")) {
				if(gestorU.altaUsuarioAdministrador(nombre, apellidos, nick, correo, contrasena, conexion)) {
					user.setMensaje("Usuario registrado correctamente.");
					response.sendRedirect(baseURL);
				}
				else{
					user.setMensaje("Fallo al registrar el usuario.");
					response.sendRedirect(baseURL);
				}
			}
			else if(tipo.equals("ESPECTADOR")) {
				if(gestorU.altaUsuarioEspectador(nombre, apellidos, nick, correo, contrasena, conexion)) {
					user.setMensaje("Usuario registrado correctamente.");
					response.sendRedirect(baseURL);
				}
				else{
					user.setMensaje("Fallo al registrar el usuario.");
					response.sendRedirect(baseURL);
				}
			}
		%>
	</body>
</html>