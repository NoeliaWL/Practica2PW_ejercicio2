<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>
<jsp:useBean id="user" class="ejercicio2.display.javabean.CustomerBean" scope="session"></jsp:useBean>
<jsp:useBean id="conexion" class="ejercicio2.display.javabean.BDBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
		
		<link rel="stylesheet" href="css/index.css">
	</head>
	<body>

		<div>
			<h2>Bienvenido a mi Aplicación Web!!</h2>
			<% String men = user.getMensaje(); %>
			<p style="color:red"><%=men%></p>

			<%
				conexion.setDriver(application.getInitParameter("DriverClass"));
				conexion.setURL(application.getInitParameter("URL"));
				conexion.setUSUARIO(application.getInitParameter("USUARIO"));
				conexion.setPASSWORD(application.getInitParameter("PASSWORD"));
				conexion.setFichero(application.getResourceAsStream(session.getServletContext().getInitParameter("SQLproperties")));
				
				String url = request.getRequestURL().toString();
				String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
				String baseURLRec = baseURL + "mvc/controller/registroController.jsp";
				String baseURLAdm = baseURL + "mvc/controller/loginAdministradorController.jsp";
				String baseURLEsp = baseURL + "mvc/controller/loginEspectadorController.jsp"; 
		
			%>
			<div>
				<form action="<%=baseURLAdm%>">
					<input type="submit" value="Acceso Administradores">
				</form>
				
				<form action="<%=baseURLEsp%>">
					<input type="submit" value="Acceso Espectadores">
				</form>
				
				<form action="<%=baseURLRec%>">
					<input type="submit" value="Registrarse">
				</form>
			</div>
		</div>
	</body>
</html>