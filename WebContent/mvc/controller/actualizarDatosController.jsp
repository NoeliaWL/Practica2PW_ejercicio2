<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ejercicio1.business.GestorUsuarios, ejercicio1.data.common.Tipousuario" %>
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
			GestorUsuarios gestor = new GestorUsuarios();
			
			Hashtable<String, String> usuario = new Hashtable<String, String>();
			Tipousuario tipo = user.getTipo();
			if(tipo == Tipousuario.ADMINISTRADOR) {
				usuario = gestor.ConsultarUsuarioAdministradores(user.getCorreoUser(), conexion);
			}
			else if(tipo == Tipousuario.ESPECTADOR) {
				//usuario = gestor.ConsultarUsuarioEspectadores(user.getCorreoUser(), conexion);
			}
			
			String nombre = "", apellidos = "", nick = "", correo = "", contrasena = "", tipoUsuario = "";
			/*String nombre = usuario.get("nombre");
			String apellidos = usuario.get("apellidos");
			String nick = usuario.get("nick");
			String correo = usuario.get("correo");
			String contrasena = usuario.get("contrasena");
			String tipoUsuario = tipo.toString();*/
			
			if(usuario.get("nombre") != null) {
				nombre = usuario.get("nombre");
			}
			
			if(usuario.get("apellidos") != null) {
				apellidos = usuario.get("apellidos");
			}
			
			if(usuario.get("nick") != null) {
				nick = usuario.get("nick");
			}
			
			if(usuario.get("correo") != null) {
				correo = usuario.get("correo");
			}
			
			if(usuario.get("contrasena") != null) {
				contrasena = usuario.get("contrasena");
			}
			
			if(usuario.get("tipo") != null) {
				tipoUsuario = usuario.get("tipo");
			}
			
			nombre = "Prueba de Usuario";
			apellidos = "Espectador apellidos";
			nick = "Nick de prueba";
			correo = "pp.pp@uco.es";
			contrasena = "159";
			tipoUsuario = tipo.toString();
			
			if(nombre == "" && apellidos == "" && nick == "" && correo == "" && contrasena == "" && tipoUsuario == "") {
				%>
				<jsp:forward page="../view/actualizarDatosView.jsp">
					<jsp:param value="<%=nombre%>" name="nombre"/>
					<jsp:param value="<%=apellidos%>" name="apellidos"/>
					<jsp:param value="<%=nick%>" name="nick"/>
					<jsp:param value="<%=correo%>" name="correo"/>
					<jsp:param value="<%=contrasena%>" name="contrasena"/>
					<jsp:param value="<%=tipoUsuario%>" name="tipo"/>
				</jsp:forward>
				<%
			}
		%>
	</body>
</html>