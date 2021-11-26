<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body onload="getParams()">
		<%
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String nick = request.getParameter("nick");
			String correo = request.getParameter("correo");
			String contrasena = request.getParameter("contrasena");
			String tipo = request.getParameter("tipo");
		%>
		<h1>Formulario para Actualizar Datos</h1>
		
		<div>
			<form action="../controller/actualizarDatosController.jsp">
				<label for="nombre">Nombre:</label>
				<input id="nombre" type="text" name="nombre" value="<%=nombre%>">
				
				<label for="apellidos">Apellidos:</label>
				<input id="apellidos" type="text" name="apellidos" value="<%=apellidos%>">
				
				<label for="nick">Nick:</label>
				<input id="nick" type="text" name="nick" value="<%=nick%>">
				
				<label for="correo">Correo:</label>
				<input id="correo" type="email" name="correo" value="<%=correo%>" disabled>
				
				<label for="password">Contraseña:</label>
				<input id="password" type="password" name="password" value="<%=contrasena%>">
				
				<select disabled>
					<%
					System.out.println("Tipo de usuario pasado: " + request.getParameter("tipo"));
					if(request.getParameter("tipo").equals("ADMINISTRADOR")){
					%>
						<option value="ADMINISTRADOR" selected>Administrador</option>
					<%
					}
					else if(request.getParameter("tipo").equals("ESPECTADOR")) {
					%>
						<option value="ESPECTADOR" selected>Espectador</option>
					<%
					}
					else {
					%>
						<option value="null" selected>Seleccione su tipo de usuario...</option>
					<%
					}
					%>
				</select>
				
	  			<input type="submit" value="Actualizar Datos">
	  			<input type="button" value="Cancelar" onclick="window.location.href='../controller/inicioEspectadorController.jsp'">
			</form>
		</div>
	</body>
</html>