<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aplicación Web</title>
	</head>
	<body>
		<h2>Formulario de registro</h2>
		
		<form action="../controller/registroController.jsp" method="post">
			<label for="nombre">Nombre:</label>
			<input id="nombre" type="text" name="nombre" required>
			
			<label for="apellidos">Apellidos:</label>
			<input id="apellidos" type="text" name="apellidos" required>
			
			<label for="nick">Nick:</label>
			<input id="nick" type="text" name="nick" required>
			
			<label for="correo">Correo:</label>
			<input id="correo" type="email" name="correo" required>
			
			<label for="password">Contraseña:</label>
			<input id="password" type="password" name="password" required>
			
			<label>Seleccione su tipo de usuario: </label>
			<input type="radio" name="tipo" id="administrador" value="ADMINISTRADOR">
			<label for="administrador">Administrador</label><br>
			<input type="radio" name="tipo" id="espectador" value="ESPECTADOR">
  			<label for="espectador">Espectador</label>
  			
  			<input type="submit" value="Registrar">
  			<input type="button" value="Cancelar" onclick="window.location.href='../../index.jsp'">
		</form>
	</body>
</html>