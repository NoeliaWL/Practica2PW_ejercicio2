package ejercicio2.display.javabean;

public class CustomerBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String correoUser = "";
	private String mensaje = "";

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
}