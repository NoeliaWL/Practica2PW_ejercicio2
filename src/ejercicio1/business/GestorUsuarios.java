package ejercicio1.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ejercicio1.data.dao.AdministradoresDAO;
import ejercicio1.data.dao.EspectadoresDAO;
import ejercicio2.display.javabean.BDBean;

public class GestorUsuarios {
	public GestorUsuarios() {
		
	}
	
	public int loginAdministrador(String correo, String contrasena, BDBean datos) {
		AdministradoresDTO administrador = new AdministradoresDTO();
		AdministradoresDAO adminDAO = new AdministradoresDAO();
		AdministradoresDTO resul;
		
		int bandera = 0;
		
		administrador.setCorreo(correo);
		administrador.setContrasena(contrasena);
		
		resul = adminDAO.consultarLogin(administrador, datos);
		
		if(administrador.getCorreo() != null){
			bandera += 1;
			if(administrador.getContrasena().equals(resul.getContrasena())){
				bandera += 1;
			}
		}
		
		return bandera;
	}
	
	public int loginEspectador(String correo, String contrasena, BDBean datos) {
		EspectadoresDTO espectador = new EspectadoresDTO();
		EspectadoresDAO espectadorDAO = new EspectadoresDAO();
		EspectadoresDTO resul;
		
		int bandera = 0;
		
		espectador.setCorreo(correo);
		espectador.setContrasena(contrasena);
		
		resul = espectadorDAO.consultarLogin(espectador, datos);
				
		if(espectador.getCorreo() != null){
			bandera += 1;
			if(espectador.getContrasena().equals(resul.getContrasena())){
				bandera += 1;
			}
		}
		
		return bandera;
	}
	
	public Boolean altaUsuarioAdministrador(String nombre, String apellidos, String nick, String correo, String contrasena, BDBean datos) {
		AdministradoresDTO administrador = new AdministradoresDTO();
		AdministradoresDAO adminDAO = new AdministradoresDAO();
		
		Boolean resultado = false;
		
		administrador.setNombre(nombre);
		administrador.setApellidos(apellidos);
		administrador.setNick(nick);
		administrador.setCorreo(correo);
		administrador.setContrasena(contrasena);
		administrador.setFechaRegistro(LocalDateTime.now());
		
		int r = adminDAO.insertarAdministrador(administrador, datos);
		
		if(r == 1){
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean altaUsuarioEspectador(String nombre, String apellidos, String nick, String correo, String contrasena, BDBean datos) {
		EspectadoresDTO espectador = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		Boolean resultado = false;
		
		espectador.setNombre(nombre);
		espectador.setApellidos(apellidos);
		espectador.setNick(nick);
		espectador.setCorreo(correo);
		espectador.setContrasena(contrasena);
		espectador.setFechaRegistro(LocalDateTime.now());
		
		int r = espectadoresDAO.insertarEspectador(espectador, datos);
		
		if(r == 1){
			resultado = true;
		}
		
		return resultado;
	}

	public Boolean bajaUsuarioAdministrador(String correo, BDBean datos) {
		AdministradoresDTO user = new AdministradoresDTO();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		
		Boolean resultado = false;
		
		user.setCorreo(correo);
		
		int r = administradoresDAO.borrarAdministrador(user, datos);
		
		if(r == 1){
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean bajaUsuarioEspectador(String correo, BDBean datos) {
		EspectadoresDTO user = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		Boolean resultado = false;
		
		user.setCorreo(correo);
		
		int r = espectadoresDAO.borrarEspectador(user, datos);
		
		if(r == 1){
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioNombreAdministrador(String correo, String nombre, BDBean datos) {
		Boolean resultado = false;
		AdministradoresDTO user = new AdministradoresDTO();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		
		user.setNombre(nombre);
		user.setCorreo(correo);
		
		if(administradoresDAO.actualizarAdministradorNombre(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioNombreEspectador(String correo, String nombre, BDBean datos) {
		Boolean resultado = false;
		EspectadoresDTO user = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		user.setNombre(nombre);
		user.setCorreo(correo);
		
		if(espectadoresDAO.actualizarEspectadorNombre(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioApellidosAdministrador(String correo, String apellidos, BDBean datos) {
		Boolean resultado = false;
		AdministradoresDTO user = new AdministradoresDTO();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		
		user.setNombre(apellidos);
		user.setCorreo(correo);
		
		if(administradoresDAO.actualizarAdministradorApellidos(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioApellidosEspectador(String correo, String apellidos, BDBean datos) {
		Boolean resultado = false;
		EspectadoresDTO user = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		user.setNombre(apellidos);
		user.setCorreo(correo);
		
		if(espectadoresDAO.actualizarEspectadorApellidos(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioNickAdministrador(String correo, String nick, BDBean datos) {
		Boolean resultado = false;
		AdministradoresDTO user = new AdministradoresDTO();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		
		user.setNombre(nick);
		user.setCorreo(correo);
		
		if(administradoresDAO.actualizarAdministradorNick(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioNickEspectador(String correo, String nick, BDBean datos) {
		Boolean resultado = false;
		EspectadoresDTO user = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		user.setNombre(nick);
		user.setCorreo(correo);
		
		if(espectadoresDAO.actualizarEspectadorNick(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioContrasenaAdministrador(String correo, String contrasena, BDBean datos) {
		Boolean resultado = false;
		AdministradoresDTO user = new AdministradoresDTO();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		
		user.setNombre(contrasena);
		user.setCorreo(correo);
		
		if(administradoresDAO.actualizarAdministradorContrasena(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Boolean ActualizarUsuarioContrasenaEspectador(String correo, String contrasena, BDBean datos) {
		Boolean resultado = false;
		EspectadoresDTO user = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		user.setNombre(contrasena);
		user.setCorreo(correo);
		
		if(espectadoresDAO.actualizarEspectadorContrasena(user, datos) == 1) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public String ConsultarUsuariosAdministradores(BDBean datos) {
		ArrayList<AdministradoresDTO> administradores = new ArrayList<AdministradoresDTO>();
		StringBuffer buffer = new StringBuffer();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		
		administradores = administradoresDAO.consultarDatos(datos);
		
		for(AdministradoresDTO a : administradores) {
			buffer.append("Nombre: " + a.getNombre());
			buffer.append("Apellidos: " + a.getApellidos());
			buffer.append("Nick: " + a.getNick());
			buffer.append("Correo: " + a.getCorreo() + "\n");
		}
		
		return buffer.toString();
	}
	
	public String ConsultarUsuariosAdministradores(String correo, BDBean datos) {
		AdministradoresDTO administradorConsultado = new AdministradoresDTO();
		AdministradoresDTO administrador = new AdministradoresDTO();
		AdministradoresDAO administradorDAO = new AdministradoresDAO();
		StringBuffer buffer = new StringBuffer();
		
		administrador.setCorreo(correo);
		
		administradorConsultado = administradorDAO.consultarUsuario(administrador, datos);
		
		buffer.append("Nombre: " + administradorConsultado.getNombre());
		buffer.append("Apellidos: " + administradorConsultado.getApellidos());
		buffer.append("Nick: " + administradorConsultado.getNick());
		buffer.append("Correo: " + administradorConsultado.getCorreo() + "\n");
		
		return buffer.toString();
	}
	
	public String ConsultarUsuariosEspectadores(BDBean datos) {
		ArrayList<EspectadoresDTO> espectadores = new ArrayList<EspectadoresDTO>();
		StringBuffer buffer = new StringBuffer();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		espectadores = espectadoresDAO.consultarDatos(datos);
		
		for(EspectadoresDTO e : espectadores) {
			buffer.append("Nombre: " + e.getNombre());
			buffer.append("Apellidos: " + e.getApellidos());
			buffer.append("Nick: " + e.getNick());
			buffer.append("Correo: " + e.getCorreo() + "\n");
		}
		
		return buffer.toString();
	}
	
	public String ConsultarUsuariosEspectadores(String correo, BDBean datos) {
		EspectadoresDTO espectadorConsultado;
		EspectadoresDTO espectador = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		espectador.setCorreo(correo);
		
		espectadorConsultado = espectadoresDAO.consultarUsuario(espectador, datos);
		
		System.out.println(espectadorConsultado.getNombre());
		
		return espectadorConsultado.getNombre();
	}
	
	public LocalDateTime ConsultarFechaRegistroEspectador(String correo, BDBean datos) {
		LocalDateTime fechaRegistro = null;
		EspectadoresDTO espectadorConsultado = new EspectadoresDTO();
		EspectadoresDTO espectador = new EspectadoresDTO();
		EspectadoresDAO espectadoresDAO = new EspectadoresDAO();
		
		espectador.setCorreo(correo);
		
		espectadorConsultado = espectadoresDAO.consultarUsuario(espectador, datos);
		
		fechaRegistro = espectadorConsultado.getFechaRegistro();
		
		System.out.println(fechaRegistro);
		
		return fechaRegistro;
	}
	
	public Boolean comprobarFormatoCorreo(String correo) {
		Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$");
		Matcher comparador = patron.matcher(correo);

		return comparador.find();
	}
}