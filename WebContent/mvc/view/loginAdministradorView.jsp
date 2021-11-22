<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="ejercicio2.display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body>
		<h3>Inicio de sesión Administrador</h3>
		<p style="color:red"><%=user.getMensaje()%></p>
		<div>
			<form action="../controller/loginAdministradorController.jsp" method="post">
				<label for="correo">Correo eléctronico:</label>
				<input id="correo" type="email" name="correo" required>
				
				<label for="password">Contraseña</label>
				<input id="password" type="password" name="password" required>
				
				<input type="submit" value="Iniciar Sesión">
				<input type="button" value="Cancelar" onclick="window.location.href='../../index.jsp'">
			</form>
		</div>
	</body>
</html>