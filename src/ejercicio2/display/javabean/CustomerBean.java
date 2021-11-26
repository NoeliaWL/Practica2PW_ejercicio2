package ejercicio2.display.javabean;

import ejercicio1.data.common.Tipousuario;

public class CustomerBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String correoUser = "";
	private String mensaje = "";
	private Tipousuario tipo = null;

	public String getCorreoUser() {
		return correoUser;
	}

	public void setCorreoUser(String correoUser) {
		this.correoUser = correoUser;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String text) {
		mensaje = text;
	}
	
	public Tipousuario getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo_user) {
		if(tipo_user == "ADMINISTRADOR") {
			tipo = Tipousuario.ADMINISTRADOR;
		}
		else if(tipo_user == "ESPECTADOR") {
			tipo = Tipousuario.ESPECTADOR;
		}
	}
}